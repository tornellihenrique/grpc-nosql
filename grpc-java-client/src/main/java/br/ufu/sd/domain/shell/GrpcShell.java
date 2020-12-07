package br.ufu.sd.domain.shell;

import br.ufu.sd.domain.service.NoSqlService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class GrpcShell {

    public static class Commands {

        public static final String SLASH = "/";

        public static final String HELP = SLASH + "help";

        public static final String EXIT = SLASH + "exit";

        public static final String CLEAR = SLASH + "clear";

        // API
        public static final String SET = SLASH + "set";

        public static final String GET = SLASH + "get";

        public static final String DEL = SLASH + "del";

        public static final String DEL_VER = SLASH + "delVer";

        public static final String TEST_AND_SET = SLASH + "testAndSet";

        // Tests
        public static final String TEST_SET = SLASH + "testSet";

        public static final String TEST_GET = SLASH + "testGet";

        public static final String TEST_DEL = SLASH + "testDel";

        public static final String TEST_VER_DEL = SLASH + "testVerDel";

        public static final String TEST_TEST_AND_SET = SLASH + "testTestAndSet";

        public static final String TEST_STRESS = SLASH + "testStress";
    }

    private final NoSqlService client;

    private final String user;

    private final Scanner sc = new Scanner(System.in);

    public GrpcShell(NoSqlService client, String user) {
        this.client = client;
        this.user = user;
    }

    public void start() {
//        handleSignals();

        System.out.print("##########################################\n" +
                "\n" +
                "███▄▄▄▄    ▄██████▄     ▄████████ ████████▄    ▄█             ▄████████  ▄█        ▄█     ▄████████ ███▄▄▄▄       ███     \n" +
                "███▀▀▀██▄ ███    ███   ███    ███ ███    ███  ███            ███    ███ ███       ███    ███    ███ ███▀▀▀██▄ ▀█████████▄ \n" +
                "███   ███ ███    ███   ███    █▀  ███    ███  ███            ███    █▀  ███       ███▌   ███    █▀  ███   ███    ▀███▀▀██ \n" +
                "███   ███ ███    ███   ███        ███    ███  ███            ███        ███       ███▌  ▄███▄▄▄     ███   ███     ███   ▀ \n" +
                "███   ███ ███    ███ ▀███████████ ███    ███  ███            ███        ███       ███▌ ▀▀███▀▀▀     ███   ███     ███     \n" +
                "███   ███ ███    ███          ███ ███    ███  ███            ███    █▄  ███       ███    ███    █▄  ███   ███     ███     \n" +
                "███   ███ ███    ███    ▄█    ███ ███  ▀ ███  ███▌    ▄      ███    ███ ███▌    ▄ ███    ███    ███ ███   ███     ███     \n" +
                " ▀█   █▀   ▀██████▀   ▄████████▀   ▀██████▀▄█ █████▄▄██      ████████▀  █████▄▄██ █▀     ██████████  ▀█   █▀     ▄████▀   \n" +
                "                                              ▀                         ▀                                                 \n\n" +
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
                        "* /help\n" +
                        "\t- Lista os comandos possíveis\n" +
                        "* /clear\n" +
                        "\t- Limpa o shell\n" +
                        "* /exit\n" +
                        "\t- Finaliza o shell\n" +
                        "\n" +
                        "* API do Banco de Dados\n" +
                        "\t- /set {key} {data:json}\n" +
                        "\t\t> Insere na chave {key} a informação {data}, sendo a mesma feita no padrão JSON (JavaScript Object Notation)\n" +
                        "\t- /get {key}\n" +
                        "\t\t> Retorna a informação armazenada na chave {key}\n" +
                        "\t- /del {key}\n" +
                        "\t\t> Remove a informação armazenada na chave {key}\n" +
                        "\t- /delVer {key} {ver}\n" +
                        "\t\t> Retorna a informação armazenada na chave {key} caso a mesma esteja na versão {ver}\n" +
                        "\t- /testAndSet {key} {ver} {data:json}\n" +
                        "\t\t> Insere na chave {key} a informação {data} caso a mesma esteja na versão {ver} e tenha sido feita no padrão JSON (JavaScript Object Notation)\n" +
                        "\n" +
                        "* Testes do Banco de Dados\n" +
                        "\t- /testSet\n" +
                        "\t\t> Realiza testes no serviço SET da API\n" +
                        "\t- /testGet\n" +
                        "\t\t> Realiza testes no serviço GET da API\n" +
                        "\t- /testDel\n" +
                        "\t\t> Realiza testes no serviço DEL da API\n" +
                        "\t- /testVerDel\n" +
                        "\t\t> Realiza testes no serviço DEL por versão da API\n" +
                        "\t- /testTestAndSet\n" +
                        "\t\t> Realiza testes no teste do serviço SET da API\n" +
                        "\t- /testStress\n" +
                        "\t\t> Realiza testes de STRESS da API\n");

                continue;
            }

            if (input.startsWith(Commands.CLEAR)) {
                clear();
                continue;
            }

            if (input.startsWith(Commands.SET + " ")) {
                set(input);
                continue;
            }

            if (input.startsWith(Commands.GET + " ")) {
                get(input);
                continue;
            }

            if (input.startsWith(Commands.DEL + " ")) {
                del(input);
                continue;
            }

            if (input.startsWith(Commands.DEL_VER + " ")) {
                delVer(input);
                continue;
            }

            if (input.startsWith(Commands.TEST_AND_SET + " ")) {
                testAndSet(input);
                continue;
            }

            if (input.startsWith(Commands.TEST_SET)) {
                System.out.println("Iniciando teste de Set...");
                client.getTestService().testSet();
                continue;
            }

            if (input.startsWith(Commands.TEST_GET)) {
                System.out.println("Iniciando teste de Get...\n");
                client.getTestService().testGet();
                continue;
            }

            if (input.startsWith(Commands.TEST_DEL)) {
                System.out.println("Iniciando teste de Del...\n");
                client.getTestService().testDel();
                continue;
            }

            if (input.startsWith(Commands.TEST_VER_DEL)) {
                System.out.println("Iniciando teste de DelVer...\n");
                client.getTestService().testDelVer();
                continue;
            }

            if (input.startsWith(Commands.TEST_TEST_AND_SET)) {
                System.out.println("Iniciando teste de TestAndSet...\n");
                client.getTestService().testTestAndSet();
                continue;
            }

            if (input.startsWith(Commands.TEST_STRESS)) {
                System.out.println("Iniciando teste de Stress...");
                client.getTestService().stressTest();
                continue;
            }

            System.out.println("Comando inválido...");
        }
    }

    // /set 111 {"array":["a","b","c"],"string":"abc","int":123,"float":1.23,"estrutura":{"teste":"uai"}}
    // SET
    private void set(String input) {
        try {
            String aux = input.replaceFirst(Commands.SET + " ", "");

            BigInteger key = new BigInteger(aux.split(" ")[0]);
            String dataStr = aux.replaceFirst(key.toString() + " ", "");

            Map<String, Object> data = new ObjectMapper().readValue(dataStr, Map.class);
            Map<String, Value> struct = getMapFromData(data);

            System.out.println(client.set(key, struct));
        } catch (Exception e) {
            System.out.println("Padrão de parâmetros inválidos");
        }
    }

    // GET
    private void get(String input) {
        try {
            String aux = input.replaceFirst(Commands.GET + " ", "");

            BigInteger key = new BigInteger(aux);

            System.out.println(client.get(key));
        } catch (Exception e) {
            System.out.println("Padrão de parâmetros inválidos");
        }
    }

    // DEL
    private void del(String input) {
        try {
            String aux = input.replaceFirst(Commands.DEL + " ", "");

            BigInteger key = new BigInteger(aux.split(" ")[0]);

            System.out.println(client.del(key));
        } catch (Exception e) {
            System.out.println("Padrão de parâmetros inválidos");
        }
    }

    // DEL VER
    private void delVer(String input) {
        try {
            String aux = input.replaceFirst(Commands.DEL_VER + " ", "");

            BigInteger key = new BigInteger(aux.split(" ")[0]);
            Long ver = Long.parseLong(aux.split(" ")[1]);

            System.out.println(client.delVer(key, ver));
        } catch (Exception e) {
            System.out.println("Padrão de parâmetros inválidos");
        }
    }

    // TEST AND SET
    private void testAndSet(String input) {
        try {
            String aux = input.replaceFirst(Commands.TEST_AND_SET + " ", "");

            BigInteger key = new BigInteger(aux.split(" ")[0]);
            aux = aux.replaceFirst(key.toString() + " ", "");

            Long ver = Long.parseLong(aux.split(" ")[0]);

            String dataStr = aux.replaceFirst(ver.toString() + " ", "");

            Map<String, Object> data = new ObjectMapper().readValue(dataStr, Map.class);
            Map<String, Value> struct = getMapFromData(data);

            System.out.println(client.testAndSet(key, ver, struct));
        } catch (Exception e) {
            System.out.println("Padrão de parâmetros inválidos");
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
            Runtime.getRuntime().exec("cls");
            System.out.print("\033[H\033[2J");
            System.out.println("\f");
            System.out.flush();
        } catch (InterruptedException | IOException e) {
            System.out.println();
        }
    }
}
