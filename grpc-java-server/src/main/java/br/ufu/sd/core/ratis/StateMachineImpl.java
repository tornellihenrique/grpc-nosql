package br.ufu.sd.core.ratis;

import br.ufu.sd.RouterServer;
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

    private static final Logger logger = Logger.getLogger(StateMachineImpl.class.getName());

    private final Map<String, String> database = new ConcurrentHashMap<>();

    @Override
    public CompletableFuture<Message> query(Message request) {
        final String query = request.getContent().toString(Charset.defaultCharset());
        final String[] queryParameters = query.split(":");

        String response = "";

        if (queryParameters.length == 0) {
            response = "Invalid parameters";
        }

        if (queryParameters[0].equals(Commands.GET)) {
            if (queryParameters.length != 2) {
                response = "Invalid GET parameters";
            }

            response = get(queryParameters[1]);
        }

        if (queryParameters[0].equals(Commands.CONTAINS_KEY)) {
            if (queryParameters.length != 2) {
                response = "Invalid CONTAINS_KEY parameters";
            }

            response = containsKey(queryParameters[1]);
        }

        return CompletableFuture.completedFuture(Message.valueOf(response));
    }


    @Override
    public CompletableFuture<Message> applyTransaction(TransactionContext trx) {
        final RaftProtos.LogEntryProto entry = trx.getLogEntry();
        final String query = entry.getStateMachineLogEntry().getLogData().toString(Charset.defaultCharset());
        final String[] queryParameters = query.split(":");

        String response = "";

        if (queryParameters.length == 0) {
            response = "Invalid parameters";
        }

        if (queryParameters[0].equals(Commands.SET)) {
            if (queryParameters.length != 3) {
                response = "Invalid SET parameters";
            }

            response = set(queryParameters[1], queryParameters[2]);
        }

        if (queryParameters[0].equals(Commands.DEL)) {
            if (queryParameters.length != 2) {
                response = "Invalid DEL parameters";
            }

            response = del(queryParameters[1]);
        }

        return CompletableFuture.completedFuture(Message.valueOf(response));
    }

    private String set(String key, String value) {
        logger.info("Using Set method on key: " + key + " and value: " + value);
        database.put(key, value);
        return "Database set success!";
    }

    private String get(String key) {
        logger.info("Using Get method on key: " + key);
        return database.get(key);
    }

    private String del(String key) {
        logger.info("Using Del method on key: " + key);
        database.remove(key);
        return "Database del success!";
    }

    private String containsKey(String key) {
        logger.info("Using ContainsKey method on key: " + key);
        return Boolean.valueOf(database.containsKey(key)).toString();
    }
}
