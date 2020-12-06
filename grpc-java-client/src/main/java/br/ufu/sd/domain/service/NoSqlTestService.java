package br.ufu.sd.domain.service;

import br.ufu.sd.api.contract.reply.DelReply;
import br.ufu.sd.api.contract.reply.GetReply;
import br.ufu.sd.api.contract.reply.SetReply;
import br.ufu.sd.api.contract.request.DelRequest;
import br.ufu.sd.api.contract.request.GetRequest;
import br.ufu.sd.api.contract.request.SetRequest;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc;
import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.Exito;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

import java.math.BigInteger;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoSqlTestService {
    private static final Logger logger = Logger.getLogger(NoSqlService.class.getName());

    private final NoSqlServiceGrpc.NoSqlServiceBlockingStub blockingStub;

    public NoSqlTestService(NoSqlServiceGrpc.NoSqlServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    public String testSet() {
        while(true) {
            BigInteger randomKey = BigInteger.valueOf((long) (Math.random() * 10000) + 1);

            GetRequest getRequest = GetRequest.newBuilder()
                    .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                    .build();

            try {
                GetReply getReply = blockingStub.get(getRequest);

                if (getReply.getExito().name().equalsIgnoreCase(Exito.SUCCESS.name())) {
                    continue;
                }

                Instant instant1 = Instant.ofEpochSecond(1000);
                Instant instant2 = Instant.ofEpochSecond(2000);

                Map<String, Value> struct1 = new HashMap<>();
                struct1.put("test", Value.newBuilder().setNumberValue(10.0D).build());

                Map<String, Value> struct2 = new HashMap<>();
                struct2.put("test", Value.newBuilder().setNumberValue(10.0D).build());

                Map<String, Value> struct3 = new HashMap<>();
                struct3.put("test", Value.newBuilder().setNumberValue(20.0D).build());

                SetRequest setRequest1 = SetRequest.newBuilder()
                        .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                        .setObjeto(Struct.newBuilder().putAllFields(struct1).build())
                        .setTimestamp(instant1.getEpochSecond()).build();

                SetRequest setRequest2 = SetRequest.newBuilder()
                        .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                        .setObjeto(Struct.newBuilder().putAllFields(struct2).build())
                        .setTimestamp(instant1.getEpochSecond()).build();

                SetRequest setRequest3 = SetRequest.newBuilder()
                        .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                        .setObjeto(Struct.newBuilder().putAllFields(struct3).build())
                        .setTimestamp(instant2.getEpochSecond()).build();

                SetReply setReply = blockingStub.set(setRequest1);

                if (setReply.getExito().name().equalsIgnoreCase(Exito.ERROR.name())) {
                    throw new Exception("Erro na primeira verificação");
                }

                setReply = blockingStub.set(setRequest2);

                if (
                    setReply.getExito().name().equalsIgnoreCase(Exito.SUCCESS.name()) ||
                    (
                        setReply.getExito().name().equalsIgnoreCase(Exito.ERROR.name()) &&
                        (
                            setReply.getValor().getVersao() != 1 ||
                            setReply.getValor().getObjeto().getFieldsMap().get("test").getNumberValue() != 10.0D
                        )
                    )
                ) {
                    throw new Exception("Erro na segunda verificação");
                }

                setReply = blockingStub.set(setRequest3);

                if (setReply.getExito().name().equalsIgnoreCase(Exito.ERROR.name())) {
                    throw new Exception("Erro na terceira verificação");
                }

                blockingStub.del(DelRequest.newBuilder()
                        .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                        .build());

                return "Teste de Set bem sucedido";
            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                return "";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    }

    public void testGet() {
        boolean isSuccess = false;
        boolean isError = false;
        int requestCounter = 0;

        while (true) {
            BigInteger randomKey = BigInteger.valueOf((long) (Math.random() * 1000) + 1);

            GetRequest getRequest = GetRequest.newBuilder()
                    .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                    .build();

            try {
                GetReply getReply = blockingStub.get(getRequest);
                requestCounter += 1;

                if (getReply.getExito().name().equalsIgnoreCase(Exito.SUCCESS.name()) && !isSuccess) {
                    System.out.println("Testando com a chave " + randomKey);
                    System.out.println(getReply);
                    isSuccess = true;
                    continue;
                }

                if (getReply.getExito().name().equalsIgnoreCase(Exito.ERROR.name()) && !isError) {
                    System.out.println("Testando com a chave " + randomKey);
                    System.out.println("exito: " + getReply.getExito() + "\n" + "valor");
                    System.out.println("\n");
                    isError = true;
                    continue;
                }

                if (!isSuccess && requestCounter > 1000) {
                    Map<String, Value> struct1 = new HashMap<>();
                    struct1.put("test", Value.newBuilder().setNumberValue(10.0D).build());

                    SetRequest newSetRequest = SetRequest.newBuilder()
                            .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                            .setObjeto(Struct.newBuilder().putAllFields(struct1).build())
                            .build();

                    SetReply newSetReply = blockingStub.set(newSetRequest);

                    GetRequest newGetRequest = GetRequest.newBuilder()
                            .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                            .build();

                    GetReply newGetReply = blockingStub.get(newGetRequest);

                    System.out.println("Testando com a chave " + randomKey);
                    System.out.println(newGetReply);
                    isSuccess = true;

                    DelRequest newDelRequest = DelRequest.newBuilder()
                            .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(randomKey.toByteArray())))
                            .build();

                    DelReply newDelReply = blockingStub.del(newDelRequest);
                    continue;
                }

                if (isSuccess && isError) {
                    System.out.println("Todos os possiveis resultados foram obtidos! Teste finalizado com sucesso!");
                    break;
                }
            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public String testDel() {
        while (true) {
            try {

            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                return "";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    }

    public String testDelVer() {
        while (true) {
            try {

            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                return "";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    }

    public String testTestAndSet() {
        while (true) {
            try {

            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                return "";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    }

    public String stressTest() {
        while (true) {
            try {

            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                return "";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    }
}
