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

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import br.ufu.sd.core.maintenance.DatabaseBackupTask;
import br.ufu.sd.core.maintenance.DatabaseMaintenance;
import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.Valor;
import br.ufu.sd.domain.service.NoSqlServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class NoSqlServer {
  private static final Logger logger = Logger.getLogger(NoSqlServer.class.getName());

  private Server server;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50051;
    
    DatabaseMaintenance<BigInt, Valor> maintenanceBean = new DatabaseMaintenance<BigInt, Valor>(System.getProperty("user.dir")
			+ File.separatorChar + "src"
			+ File.separatorChar + "main"
			+ File.separatorChar + "resources" 
			+ File.separatorChar + "db" 
			+ File.separatorChar + "nosql_database2.backup");
    
    NoSqlServiceImpl noSqlService = new NoSqlServiceImpl(maintenanceBean);
    
    Timer serverMaintainanceTimer = new Timer();
    
    serverMaintainanceTimer.schedule(
    		new DatabaseBackupTask(noSqlService.getDatabase(), maintenanceBean), 5_000, 5_000);
    
    server = ServerBuilder.forPort(port)
        .addService(noSqlService)
        .build()
        .start();
    
    logger.info("Server started, listening on " + port);
    
    
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
        	NoSqlServer.this.stop();
        	serverMaintainanceTimer.cancel();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        System.err.println("*** server shut down");
      }
    });
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
    final NoSqlServer server = new NoSqlServer();
    server.start();
    server.blockUntilShutdown();
  }
  
 
}
