package br.ufu.sd;

import br.ufu.sd.core.ratis.RatisServer;
import br.ufu.sd.domain.model.RaftAddressConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseServer {
    private static final Logger logger = Logger.getLogger(DatabaseServer.class.getName());

    private void start(String raftPeerId) {
        try {
            String grouUuid = "raft_group____um";

            List<RaftAddressConfig> addressList = new ArrayList<>();

            addressList.add(new RaftAddressConfig("p1", "127.0.0.1", 3000));
            addressList.add(new RaftAddressConfig("p2", "127.0.0.1", 3500));
            addressList.add(new RaftAddressConfig("p3", "127.0.0.1", 4000));

            RatisServer ratisServer = new RatisServer(raftPeerId, grouUuid, addressList);

            ratisServer.start();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseServer databaseServer = new DatabaseServer();
        databaseServer.start(args[0]);
    }
}
