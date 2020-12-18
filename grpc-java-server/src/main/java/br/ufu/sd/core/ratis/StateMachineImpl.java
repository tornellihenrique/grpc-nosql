package br.ufu.sd.core.ratis;

import br.ufu.sd.GrpcRouterServer;
import org.apache.ratis.proto.RaftProtos;
import org.apache.ratis.protocol.Message;
import org.apache.ratis.statemachine.TransactionContext;
import org.apache.ratis.statemachine.impl.BaseStateMachine;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class StateMachineImpl extends BaseStateMachine {

    public static class Commands {
        public static final String SET = "set";

        public static final String GET = "get";

        public static final String DEL = "del";

        public static final String CONTAINS_KEY = "containsKey";
    }

    private static final Logger logger = Logger.getLogger(GrpcRouterServer.class.getName());

    private final Map<String, String> database = new ConcurrentHashMap<>();

    @Override
    public CompletableFuture<Message> query(Message request) {
        final String query = request.getContent().toString(Charset.defaultCharset());
        final String[] queryParameters = query.split(":");

        String response = "";

        if (queryParameters.length != 2) {
            response = "Invalid parameters";
        }

        if (queryParameters[0].equals(Commands.GET)) {
            response = get(queryParameters[1]);
        }

        if (queryParameters[0].equals(Commands.CONTAINS_KEY)) {
            response = containsKey(queryParameters[1]);
        }

        return CompletableFuture.completedFuture(Message.valueOf(response));
    }


    @Override
    public CompletableFuture<Message> applyTransaction(TransactionContext trx) {
        final RaftProtos.LogEntryProto entry = trx.getLogEntry();
        final String[] opKeyValue = entry.getStateMachineLogEntry().getLogData().toString(Charset.defaultCharset()).split(":");

        final String result = opKeyValue[0]+ ":"+ database.put(opKeyValue[1], opKeyValue[2]);

        final CompletableFuture<Message> f = CompletableFuture.completedFuture(Message.valueOf(result));

        final RaftProtos.RaftPeerRole role = trx.getServerRole();
        LOG.info("{}:{} {} {}={}", role, getId(), opKeyValue[0], opKeyValue[1], opKeyValue[2]);

        if (LOG.isTraceEnabled()) {
            LOG.trace("{}: key/values={}", getId(), database);
        }

        return f;
    }

    private String set() {
        return null;
    }

    private String get(String key) {
        logger.info("Using Get method on key: " + key);
        return database.get(key);
    }

    private String del() {
        return null;
    }

    private String containsKey(String key) {
        logger.info("Using ContainsKey method on key: " + key);
        return Boolean.valueOf(database.containsKey(key)).toString();
    }
}
