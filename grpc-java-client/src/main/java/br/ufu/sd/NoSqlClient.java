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
  public void set() {
    Map<String, Value> struct = new HashMap<>();
    struct.put("nome", Value.newBuilder().setStringValue("Davide").build());
    struct.put("sobrenome", Value.newBuilder().setStringValue("Sgalambro").build());
    struct.put("idade", Value.newBuilder().setNumberValue(25).build());
    struct.put("ensino", Value.newBuilder().setStringValue("superior").build());
//    1605923573866
//    1605926385089
//    Instant.now().getEpochSecond()
    SetRequest request = SetRequest.newBuilder()
    					.setKey(BigInt.newBuilder().setValue(ByteString.copyFrom(new BigInteger("2").toByteArray())))
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

  /**
    MEME GENERATOR
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting. The second argument is the target server.
   */
  public static void main(String[] args) throws Exception {
    String user = "world";
    // Access a service running on the local machine on port 50051
    String target = "localhost:50051";
    // Allow passing in the user and target strings as command line arguments
    if (args.length > 0) {
      if ("--help".equals(args[0])) {
        System.err.println("Usage: [name [target]]");
        System.err.println("");
        System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
        System.err.println("  target  The server to connect to. Defaults to " + target);
        System.exit(1);
      }
      user = args[0];
    }
    if (args.length > 1) {
      target = args[1];
    }

    // Create a communication channel to the server, known as a Channel. Channels are thread-safe
    // and reusable. It is common to create channels at the beginning of your application and reuse
    // them until the application shuts down.
    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build();
    try {
      NoSqlClient client = new NoSqlClient(channel);
      client.set();
    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
      // resources the channel should be shut down when it will no longer be used. If it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
