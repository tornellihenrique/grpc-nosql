# NoSQL DB with gRPC

A simple HashTable based NoSQL database project that implements the [RPC Communication](https://en.wikipedia.org/wiki/Remote_procedure_call) throw the Google framework [gRPC](https://grpc.io/) using the Java (8 or higher) language.

This is a final project for the Distributed Systems course from the program Information Systems in the university [UFU](http://www.ufu.br/).

### Group members
- Gabriel Dal Belo
- Carlos Humberto
- Arthur Maia
- Henrique Tornelli
- Davide Sgalambro
- Vitor Manoel

### Getting started
First of all, lets build the project

1. Building server
```bash
$ cd grpc-java-server
$ mvn clean install

# ... Build ...

$ cd ..
```

2. Building client
```bash
$ cd grpc-java-client
$ mvn clean install

# ... Build ...

$ cd ..
```

It will generate two jars on each build: a standard one, and another one with dependencies.

In the server, the jar is at `grpc-nosql/grpc-java-server/target/grpc-java-server-{version}-jar-with-dependencies.jar`.

In the client, the jar is at `grpc-nosql/grpc-java-client/target/grpc-java-client-{version}-jar-with-dependencies.jar`.

3. Starting server
```bash
# Remember, the local databash backup will be created at your terminal located folder, in this case, the source folder 'grpc-nosql'
$ java -jar grpc-java-server/target/grpc-java-server-{version}-jar-with-dependencies.jar
```

**Now the server will be running at the 50051 port and will be backing up every 5 seconds.**

4. Starting client
```
# You can optionally pass as argument an username for the client welcome message
$ java -jar grpc-java-client/target/grpc-java-client-{version}-jar-with-dependencies.jar CustomUsername
```

5. Enjoy :) The client welcome message will introduce you to the commands
