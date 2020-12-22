# NoSQL DB with gRPC

A simple HashTable based NoSQL database project that implements [RPC Communication](https://en.wikipedia.org/wiki/Remote_procedure_call) through [gRPC](https://grpc.io/), a framework made by Google.
For the data state management and error tolerance, the project also uses the [Apache Ratis](http://ratis.incubator.apache.org/), a highly customizable [Raft](https://raft.github.io/) protocol implementation.

This is a final project for the Information Systems program's "Distributed Systems" course, in the [Federal University of Uberlândia](http://www.ufu.br/).

### Group members
- Gabriel Dal Belo
- Carlos Humberto
- Arthur Maia
- Henrique Tornelli
- Davide Sgalambro
- Vitor Manoel

### Getting started
First of all, lets build the project

1. Building Router and Database Server
```bash
$ cd grpc-java-server
$ mvn clean install

# ... Maven Build ...

$ cd ..
```

It will generate three jars: a standard one (that will be ignored), a database server one and a router server one.

2. Building Client
```bash
$ cd grpc-java-client
$ mvn clean install

# ... Maven Build ...

$ cd ..
```

It will generate two jars: a standard one, and another one with dependencies.

3. Starting Database Server

The Ratis implementation is configured for use three instances and backup the data at `/tmp` folder:
- p1: 127.0.0.1:3000
- p2: 127.0.0.1:3500
- p3: 127.0.0.1:4000

So we need to start them:

```bash
# Each one in a different terminal
$ java -jar grpc-nosql/grpc-java-server/target/database-server-jar-with-dependencies.jar p1

$ java -jar grpc-nosql/grpc-java-server/target/database-server-jar-with-dependencies.jar p2

$ java -jar grpc-nosql/grpc-java-server/target/database-server-jar-with-dependencies.jar p3
```

4. Starting Router Server

In the server, the jar is at `grpc-nosql/grpc-java-server/target/router-server-jar-with-dependencies.jar`.

```bash
$ java -jar grpc-java-server/target/router-server-jar-with-dependencies.jar
```

**Now the server will be running at the 50051 port and will be backing up every 5 seconds.**

5. Starting client

In the client, the jar is at `grpc-nosql/grpc-java-client/target/database-server-jar-with-dependencies.jar`.

```bash
# You can optionally pass as argument an username for the client welcome message
$ java -jar grpc-java-client/target/database-server-jar-with-dependencies.jar CustomUsername
```

6. Enjoy :) The client welcome message will introduce you to the commands
