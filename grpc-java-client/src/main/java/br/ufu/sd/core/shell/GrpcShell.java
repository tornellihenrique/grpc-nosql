package br.ufu.sd.core.shell;

import br.ufu.sd.NoSqlClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class GrpcShell {

    public static class Commands {

        public static final String SLASH = "/";

        public static final String HELP = SLASH + "help";

        public static final String EXIT = SLASH + "exit";

        // API
        public static final String SET = SLASH + "set";

        public static final String GET = SLASH + "get";

        // Tests
        public static final String TEST_SET = SLASH + "testSet";

        public static final String TEST_GET = SLASH + "testGet";
    }

    private final NoSqlClient client;

    private final String user;

    private final Scanner sc = new Scanner(System.in);

    public GrpcShell(NoSqlClient client, String user) {
        this.client = client;
        this.user = user;
    }

    public void start() {
        System.out.print("##########################################\n" +
                "########### NOSQL SHELL CLIENT ###########\n" +
                "##########################################\n" +
                "\n" +
                "##########################################\n" +
                "##### Seja bem vindo, " + user + " :)\n" +
                "##########################################\n" +
                "##### Primeiro acesso? ###################\n" +
                "##### Tente utilizar o comando /help ;) ##\n" +
                "##########################################\n");

        String input;

        while (true) {
            input = getInput();

            if (input.startsWith(Commands.EXIT)) {
                System.out.println("Até mais meu nobre...");
                break;
            }

            if (input.startsWith(Commands.HELP)) {
                System.out.println("Comandos disponíveis:\n" +
                        "\n" +
                        "* API do Banco de Dados\n" +
                        "\t- /set {key} {data:json}\n" +
                        "\t\t> Insere na chave {key} a informação {data} sendo ela feita no padrão JSON (JavaScript Object Notation)\n" +
                        "\t- /get {key}\n" +
                        "\t\t> Retorna a informação armazenada na chave {key}\n" +
                        "\n" +
                        "* Testes do Banco de Dados\n" +
                        "\t- /testSet\n" +
                        "\t\t> Realiza testes no serviço SET da API\n" +
                        "\t- /testGet\n" +
                        "\t\t> Realiza testes no serviço GET da API");

                continue;
            }

            // /set 111 {"array":["a","b","c"],"string":"abc","int":123,"float":1.23,"estrutura":{"teste":"uai"}}
            if (input.startsWith(Commands.SET)) {
                try {
                    String aux = input.replace(Commands.SET + " ", "");

                    BigInteger key = new BigInteger(aux.split(" ")[0]);
                    String dataStr = aux.replace(key.toString() + " ", "");

                    Map<String, Object> data = new ObjectMapper().readValue(dataStr, Map.class);
                    Map<String, Value> struct = getMapFromData(data);

                    client.set(key, struct);
                } catch (Exception e) {
                    System.out.println("Padrão de parâmetros inválidos");
                }

                continue;
            }

            System.out.println("Comando inválido ಠ_ಠ"); //TODO Remover emoji
        }
    }

    private String getInput() {
        System.out.print("\n$ ");
        return sc.nextLine();
    }

    private Map<String, Value> getMapFromData(Map<String, Object> data) {
        return data.keySet().stream().collect(Collectors.toMap(k -> k, k -> getValueFromData(data.get(k))));
    }

    private Value getValueFromData(Object obj) {
        if (obj instanceof Map) {
            return Value.newBuilder().setStructValue(Struct.newBuilder().putAllFields(getMapFromData((Map<String, Object>) obj)).build()).build();
        }

        if (obj instanceof List) {
            return Value.newBuilder().setListValue(ListValue.newBuilder().addAllValues(((List<Object>) obj).stream().map(this::getValueFromData).collect(Collectors.toList())).build()).build();
        }

        if (obj instanceof Integer) {
            return Value.newBuilder().setNumberValue((double) ((Integer) obj)).build();
        }

        if (obj instanceof Double) {
            return Value.newBuilder().setNumberValue((double) obj).build();
        }

        if (obj instanceof String) {
            return Value.newBuilder().setStringValue((String) obj).build();
        }

        return Value.newBuilder().setStringValue("invalid").build();
    }

    private void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            System.out.println();
        }
    }
}
