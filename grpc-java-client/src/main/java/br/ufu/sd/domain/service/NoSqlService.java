package br.ufu.sd.domain.service;
/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import java.math.BigInteger;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufu.sd.api.contract.reply.*;
import br.ufu.sd.api.contract.request.*;
import br.ufu.sd.domain.model.Exito;
import br.ufu.sd.domain.model.Valor;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;


public class NoSqlService {
  private static final Logger logger = Logger.getLogger(NoSqlService.class.getName());

  private final NoSqlServiceGrpc.NoSqlServiceBlockingStub blockingStub;

  private final NoSqlTestService noSqlTestService;

  public NoSqlService(Channel channel) {
    blockingStub = NoSqlServiceGrpc.newBlockingStub(channel);
    noSqlTestService = new NoSqlTestService(blockingStub);
  }

  public NoSqlTestService getTestService() {
    return noSqlTestService;
  }

  public String set(BigInteger key, Map<String, Value> struct) {
    SetRequest request = SetRequest.newBuilder()
      .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(key.toByteArray())))
      .setObjeto(Struct.newBuilder().putAllFields(struct).build())
      .setTimestamp(Instant.now().getEpochSecond()).build();

    SetReply reply;

    try {
      reply = blockingStub.set(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return "";
    }

    return getParsedReply("Set", reply.getExito().name(), reply.getValor().toString());
  }

  public String get(BigInteger key) {
    GetRequest request = GetRequest.newBuilder()
      .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(key.toByteArray())))
      .build();

    GetReply reply;

    try {
      reply = blockingStub.get(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return "";
    }

    return getParsedReply("Get", reply.getExito().name(), reply.getValor().toString());
  }
  
  public String del(BigInteger key) {
    DelRequest request = DelRequest.newBuilder()
            .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(key.toByteArray())))
            .build();

    DelReply reply;

    try {
      reply = blockingStub.del(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return "";
    }

    return getParsedReply("Del", reply.getExito().name(), reply.getValor().toString());
  }

  public String delVer(BigInteger key, Long ver) {
    DelVerRequest request = DelVerRequest.newBuilder()
            .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(key.toByteArray())))
            .setVersao(ver)
            .build();

    DelVerReply reply;

    try {
      reply = blockingStub.delVer(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return "";
    }

    return getParsedReply("DelVer", reply.getExito().name(), reply.getValor().toString());
  }

  public String testAndSet(BigInteger key, Long ver, Map<String, Value> struct) {
    TestAndSetRequest request = TestAndSetRequest.newBuilder()
            .setChave(BigInt.newBuilder().setValue(ByteString.copyFrom(key.toByteArray())))
            .setVersao(ver)
            .setObjeto(Struct.newBuilder().putAllFields(struct).build())
            .build();

    TestAndSetReply reply;

    try {
      reply = blockingStub.testAndSet(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return "";
    }

    return getParsedReply("TestAndSet", reply.getExito().name(), reply.getValor().toString());
  }

  private String getParsedReply(String name, String e, String v) {
    return String.format("Resposta do %s:\n\n" +
            "E  : %s\n" +
            "V' :\n" +
            "%s", name, e, v);
  }

}
