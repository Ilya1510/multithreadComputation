package ru.mipt.java2017.hw2;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: Computation.proto")
public final class ComputatorGrpc {

  private ComputatorGrpc() {}

  public static final String SERVICE_NAME = "ru.mipt.java2017.hw2.Computator";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ru.mipt.java2017.hw2.SegmentRequest,
      ru.mipt.java2017.hw2.SumReply> METHOD_COMPUTE =
      io.grpc.MethodDescriptor.<ru.mipt.java2017.hw2.SegmentRequest, ru.mipt.java2017.hw2.SumReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ru.mipt.java2017.hw2.Computator", "compute"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ru.mipt.java2017.hw2.SegmentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ru.mipt.java2017.hw2.SumReply.getDefaultInstance()))
          .setSchemaDescriptor(new ComputatorMethodDescriptorSupplier("compute"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ComputatorStub newStub(io.grpc.Channel channel) {
    return new ComputatorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComputatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ComputatorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ComputatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ComputatorFutureStub(channel);
  }

  /**
   */
  public static abstract class ComputatorImplBase implements io.grpc.BindableService {

    /**
     */
    public void compute(ru.mipt.java2017.hw2.SegmentRequest request,
        io.grpc.stub.StreamObserver<ru.mipt.java2017.hw2.SumReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_COMPUTE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_COMPUTE,
            asyncUnaryCall(
              new MethodHandlers<
                ru.mipt.java2017.hw2.SegmentRequest,
                ru.mipt.java2017.hw2.SumReply>(
                  this, METHODID_COMPUTE)))
          .build();
    }
  }

  /**
   */
  public static final class ComputatorStub extends io.grpc.stub.AbstractStub<ComputatorStub> {
    private ComputatorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputatorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputatorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputatorStub(channel, callOptions);
    }

    /**
     */
    public void compute(ru.mipt.java2017.hw2.SegmentRequest request,
        io.grpc.stub.StreamObserver<ru.mipt.java2017.hw2.SumReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_COMPUTE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ComputatorBlockingStub extends io.grpc.stub.AbstractStub<ComputatorBlockingStub> {
    private ComputatorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputatorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputatorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.mipt.java2017.hw2.SumReply compute(ru.mipt.java2017.hw2.SegmentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_COMPUTE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ComputatorFutureStub extends io.grpc.stub.AbstractStub<ComputatorFutureStub> {
    private ComputatorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputatorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputatorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.mipt.java2017.hw2.SumReply> compute(
        ru.mipt.java2017.hw2.SegmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_COMPUTE, getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ComputatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ComputatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE:
          serviceImpl.compute((ru.mipt.java2017.hw2.SegmentRequest) request,
              (io.grpc.stub.StreamObserver<ru.mipt.java2017.hw2.SumReply>) responseObserver);
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

  private static abstract class ComputatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComputatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.mipt.java2017.hw2.ComputatorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Computator");
    }
  }

  private static final class ComputatorFileDescriptorSupplier
      extends ComputatorBaseDescriptorSupplier {
    ComputatorFileDescriptorSupplier() {}
  }

  private static final class ComputatorMethodDescriptorSupplier
      extends ComputatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ComputatorMethodDescriptorSupplier(String methodName) {
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
      synchronized (ComputatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ComputatorFileDescriptorSupplier())
              .addMethod(METHOD_COMPUTE)
              .build();
        }
      }
    }
    return result;
  }
}
