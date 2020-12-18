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

package br.ufu.sd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufu.sd.domain.model.RaftAddressConfig;
import br.ufu.sd.domain.service.NoSqlServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class GrpcRouterServer {
  private static final Logger logger = Logger.getLogger(GrpcRouterServer.class.getName());

  private Server server;

  private void start(int port) throws IOException {
    NoSqlServiceImpl noSqlService;

    try {
      String grouUuid = "raft_group____um";

      List<RaftAddressConfig> addressList = new ArrayList<>();

      addressList.add(new RaftAddressConfig("p1", "127.0.0.1", 3000));
      addressList.add(new RaftAddressConfig("p2", "127.0.0.1", 3500));
      addressList.add(new RaftAddressConfig("p2", "127.0.0.1", 4000));

      noSqlService = new NoSqlServiceImpl(grouUuid, addressList);
    } catch (Exception e) {
      logger.log(Level.WARNING, e.getMessage());
      return;
    }

    server = ServerBuilder.forPort(port)
        .addService(noSqlService)
        .build()
        .start();
    
    logger.info("Server started, listening on " + port);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      // Use stderr here since the logger may have been reset by its JVM shutdown hook.
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      try {
          GrpcRouterServer.this.stop();
      } catch (InterruptedException e) {
        e.printStackTrace(System.err);
      }
      System.err.println("*** server shut down");
    }));
  }

  private void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final GrpcRouterServer server = new GrpcRouterServer();
    server.start(50051);
    server.blockUntilShutdown();
  }

 
  
}
