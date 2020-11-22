package br.ufu.sd.core.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * servico de banco de dados nosql
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.0)",
    comments = "Source: nosql_database.proto")
public final class NoSqlServiceGrpc {

  private NoSqlServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.NoSqlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.ufu.sd.api.contract.request.SetRequest,
      br.ufu.sd.api.contract.reply.SetReply> getSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "set",
      requestType = br.ufu.sd.api.contract.request.SetRequest.class,
      responseType = br.ufu.sd.api.contract.reply.SetReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.ufu.sd.api.contract.request.SetRequest,
      br.ufu.sd.api.contract.reply.SetReply> getSetMethod() {
    io.grpc.MethodDescriptor<br.ufu.sd.api.contract.request.SetRequest, br.ufu.sd.api.contract.reply.SetReply> getSetMethod;
    if ((getSetMethod = NoSqlServiceGrpc.getSetMethod) == null) {
      synchronized (NoSqlServiceGrpc.class) {
        if ((getSetMethod = NoSqlServiceGrpc.getSetMethod) == null) {
          NoSqlServiceGrpc.getSetMethod = getSetMethod =
              io.grpc.MethodDescriptor.<br.ufu.sd.api.contract.request.SetRequest, br.ufu.sd.api.contract.reply.SetReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "set"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.ufu.sd.api.contract.request.SetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.ufu.sd.api.contract.reply.SetReply.getDefaultInstance()))
              .setSchemaDescriptor(new NoSqlServiceMethodDescriptorSupplier("set"))
              .build();
        }
      }
    }
    return getSetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NoSqlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NoSqlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NoSqlServiceStub>() {
        @java.lang.Override
        public NoSqlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NoSqlServiceStub(channel, callOptions);
        }
      };
    return NoSqlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NoSqlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NoSqlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NoSqlServiceBlockingStub>() {
        @java.lang.Override
        public NoSqlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NoSqlServiceBlockingStub(channel, callOptions);
        }
      };
    return NoSqlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NoSqlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NoSqlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NoSqlServiceFutureStub>() {
        @java.lang.Override
        public NoSqlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NoSqlServiceFutureStub(channel, callOptions);
        }
      };
    return NoSqlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * servico de banco de dados nosql
   * </pre>
   */
  public static abstract class NoSqlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * metodo para salvar uma tupla no banco de dados NoSQL
     * </pre>
     */
    public void set(br.ufu.sd.api.contract.request.SetRequest request,
        io.grpc.stub.StreamObserver<br.ufu.sd.api.contract.reply.SetReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.ufu.sd.api.contract.request.SetRequest,
                br.ufu.sd.api.contract.reply.SetReply>(
                  this, METHODID_SET)))
          .build();
    }
  }

  /**
   * <pre>
   * servico de banco de dados nosql
   * </pre>
   */
  public static final class NoSqlServiceStub extends io.grpc.stub.AbstractAsyncStub<NoSqlServiceStub> {
    private NoSqlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NoSqlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NoSqlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * metodo para salvar uma tupla no banco de dados NoSQL
     * </pre>
     */
    public void set(br.ufu.sd.api.contract.request.SetRequest request,
        io.grpc.stub.StreamObserver<br.ufu.sd.api.contract.reply.SetReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * servico de banco de dados nosql
   * </pre>
   */
  public static final class NoSqlServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NoSqlServiceBlockingStub> {
    private NoSqlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NoSqlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NoSqlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * metodo para salvar uma tupla no banco de dados NoSQL
     * </pre>
     */
    public br.ufu.sd.api.contract.reply.SetReply set(br.ufu.sd.api.contract.request.SetRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * servico de banco de dados nosql
   * </pre>
   */
  public static final class NoSqlServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NoSqlServiceFutureStub> {
    private NoSqlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NoSqlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NoSqlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * metodo para salvar uma tupla no banco de dados NoSQL
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<br.ufu.sd.api.contract.reply.SetReply> set(
        br.ufu.sd.api.contract.request.SetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NoSqlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NoSqlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET:
          serviceImpl.set((br.ufu.sd.api.contract.request.SetRequest) request,
              (io.grpc.stub.StreamObserver<br.ufu.sd.api.contract.reply.SetReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NoSqlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NoSqlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NoSqlService");
    }
  }

  private static final class NoSqlServiceFileDescriptorSupplier
      extends NoSqlServiceBaseDescriptorSupplier {
    NoSqlServiceFileDescriptorSupplier() {}
  }

  private static final class NoSqlServiceMethodDescriptorSupplier
      extends NoSqlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NoSqlServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NoSqlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NoSqlServiceFileDescriptorSupplier())
              .addMethod(getSetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
