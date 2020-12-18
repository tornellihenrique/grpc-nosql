package br.ufu.sd.core.ratis;

import br.ufu.sd.RouterServer;
import br.ufu.sd.domain.model.RaftAddressConfig;
import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcConfigKeys;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.RaftServerConfigKeys;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.util.LifeCycle;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RatisServer {

    private static final Logger logger = Logger.getLogger(RatisServer.class.getName());

    private final RaftServer raftServer;

    public RatisServer(String raftPeerId, String groupUuid, List<RaftAddressConfig> addressConfigList) throws Exception {
        if (groupUuid == null) {
            throw new Exception("Invalid Group UUID");
        }

        if (groupUuid.length() != 16) {
            throw new Exception("Invalid Group UUID - Must have 16 characters");
        }

        Map<String, InetSocketAddress> id2addr = addressConfigList
                .stream()
                .collect(Collectors.toMap(RaftAddressConfig::getId, a -> new InetSocketAddress(a.getHost(), a.getPort())));

        List<RaftPeer> addresses = id2addr.entrySet()
                .stream()
                .map(e -> new RaftPeer(RaftPeerId.valueOf(e.getKey()), e.getValue()))
                .collect(Collectors.toList());

        RaftPeerId id = RaftPeerId.valueOf(raftPeerId);

        if (addresses.stream().noneMatch(p -> p.getId().equals(id))) {
            logger.log(Level.WARNING,"Invalid identifier: " + raftPeerId);
            System.exit(1);
        }

        RaftProperties properties = new RaftProperties();
        properties.setInt(GrpcConfigKeys.OutputStream.RETRY_TIMES_KEY, Integer.MAX_VALUE);
        GrpcConfigKeys.Server.setPort(properties, id2addr.get(raftPeerId).getPort());
        RaftServerConfigKeys.setStorageDir(properties, Collections.singletonList(new File("/tmp/" + id)));

        final RaftGroup raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(groupUuid)), addresses);

        raftServer = RaftServer.newBuilder()
                .setServerId(id)
                .setStateMachine(new StateMachineImpl()).setProperties(properties)
                .setGroup(raftGroup)
                .build();
    }

    public void start() throws Exception {
        raftServer.start();

        logger.info("RatisServer started!");

        while (raftServer.getLifeCycleState() != LifeCycle.State.CLOSED) {
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
