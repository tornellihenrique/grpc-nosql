package br.ufu.sd.core.ratis;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.ratis.client.RaftClient;
import org.apache.ratis.conf.Parameters;
import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcFactory;
import org.apache.ratis.protocol.ClientId;
import org.apache.ratis.protocol.Message;
import org.apache.ratis.protocol.RaftClientReply;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;

import com.google.protobuf.InvalidProtocolBufferException;

import br.ufu.sd.GrpcRouterServer;
import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.RaftAddressConfig;
import br.ufu.sd.domain.model.Valor;

public class RatisClient {

    private static final Logger logger = Logger.getLogger(GrpcRouterServer.class.getName());

    private final RaftClient client;

    public RatisClient(String groupUuid, List<RaftAddressConfig> addressConfigList) throws Exception {
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

        final RaftGroup raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(groupUuid)), addresses);

        RaftProperties raftProperties = new RaftProperties();

        client = RaftClient.newBuilder()
                .setProperties(raftProperties)
                .setRaftGroup(raftGroup)
                .setClientRpc(new GrpcFactory(new Parameters())
                        .newRaftClientRpc(ClientId.randomId(), raftProperties))
                .build();
    }

    public void set(BigInt key, Valor value) {
        RaftClientReply raftResponse = null;
        try {
            raftResponse = client.send(Message.valueOf("set:" + key.toByteString() + ":" + value.toByteString()));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error on Persistence Set");
            return;
        }

        String response = raftResponse.getMessage().getContent().toString(Charset.defaultCharset());
        logger.log(Level.INFO, response);
    }

    public Valor get(BigInt key) {
        RaftClientReply raftResponse = null;
        try {
            raftResponse = client.sendReadOnly(Message.valueOf("get:" + key.toByteString()));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error on Persistence Get");
            return null;
        }

        String response = raftResponse.getMessage().getContent().toString(Charset.defaultCharset());
        logger.log(Level.INFO, response);

        try {
            return Valor.parseFrom(raftResponse.getMessage().getContent().toString().getBytes());
        } catch (InvalidProtocolBufferException e) {
            logger.log(Level.WARNING, "Error on parsing Persistence Get response");
            return null;
        }
    }

    public void del(BigInt key) {
        RaftClientReply raftResponse = null;
        try {
            raftResponse = client.send(Message.valueOf("del:" + key.toByteString()));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error on Persistence Del");
            return;
        }

        String response = raftResponse.getMessage().getContent().toString(Charset.defaultCharset());
        logger.log(Level.INFO, response);
    }

    public Boolean containsKey(BigInt key) {
        RaftClientReply raftResponse = null;
        try {
            raftResponse = client.sendReadOnly(Message.valueOf("containsKey:" + key.toByteString()));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error on Persistence ContainsKey");
            return null;
        }

        String response = raftResponse.getMessage().getContent().toString(Charset.defaultCharset());
        logger.log(Level.INFO, response);

        return raftResponse.getMessage().toString().equalsIgnoreCase("NULL");
    }
}
