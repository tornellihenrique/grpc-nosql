package br.ufu.sd;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import br.ufu.sd.api.contract.reply.SetReply;
import br.ufu.sd.api.contract.request.SetRequest;
import br.ufu.sd.api.contract.request.SetRequest.BigInt;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


/**
 * A simple client that requests a greeting from the {@link HelloWorldServer}.
 */
public class NoSqlClient {
  private static final Logger logger = Logger.getLogger(NoSqlClient.class.getName());

  private final NoSqlServiceGrpc.NoSqlServiceBlockingStub blockingStub;

  /** Construct client for accessing HelloWorld server using the existing channel. */
  public NoSqlClient(Channel channel) {
    // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
    // shut it down.

    // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
    blockingStub = NoSqlServiceGrpc.newBlockingStub(channel);
  }

  /** Say hello to server. */
  public void set(BigInteger key, Map<String, Value> struct) {
    SetRequest request = SetRequest.newBuilder()
      .setKey(BigInt.newBuilder().setValue(ByteString.copyFrom(key.toByteArray())))
      .setObjeto(Struct.newBuilder().putAllFields(struct).build())
      .setTimestamp(Instant.now().getEpochSecond()).build();

    SetReply response;

    try {
      response = blockingStub.set(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }

    logger.info("Set Response : { exito : '" + response.getExito().name() +  "' , v : { " +  (response.getValor()==null ? "NULL" : response.getValor()) + " } }");
  }

}
