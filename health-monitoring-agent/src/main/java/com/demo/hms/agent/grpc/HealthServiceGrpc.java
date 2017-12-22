package com.demo.hms.agent.grpc;

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
    comments = "Source: health-service.proto")
public final class HealthServiceGrpc {

  private HealthServiceGrpc() {}

  public static final String SERVICE_NAME = "HealthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.demo.hms.agent.grpc.HealthMetrics,
      com.demo.hms.agent.grpc.HealthMetricsResponse> METHOD_SEND_HEALTH_METRICS =
      io.grpc.MethodDescriptor.<com.demo.hms.agent.grpc.HealthMetrics, com.demo.hms.agent.grpc.HealthMetricsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "HealthService", "sendHealthMetrics"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.demo.hms.agent.grpc.HealthMetrics.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.demo.hms.agent.grpc.HealthMetricsResponse.getDefaultInstance()))
          .setSchemaDescriptor(new HealthServiceMethodDescriptorSupplier("sendHealthMetrics"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthServiceStub newStub(io.grpc.Channel channel) {
    return new HealthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HealthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HealthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HealthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendHealthMetrics(com.demo.hms.agent.grpc.HealthMetrics request,
        io.grpc.stub.StreamObserver<com.demo.hms.agent.grpc.HealthMetricsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_HEALTH_METRICS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_HEALTH_METRICS,
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.hms.agent.grpc.HealthMetrics,
                com.demo.hms.agent.grpc.HealthMetricsResponse>(
                  this, METHODID_SEND_HEALTH_METRICS)))
          .build();
    }
  }

  /**
   */
  public static final class HealthServiceStub extends io.grpc.stub.AbstractStub<HealthServiceStub> {
    private HealthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendHealthMetrics(com.demo.hms.agent.grpc.HealthMetrics request,
        io.grpc.stub.StreamObserver<com.demo.hms.agent.grpc.HealthMetricsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_HEALTH_METRICS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HealthServiceBlockingStub extends io.grpc.stub.AbstractStub<HealthServiceBlockingStub> {
    private HealthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.demo.hms.agent.grpc.HealthMetricsResponse sendHealthMetrics(com.demo.hms.agent.grpc.HealthMetrics request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_HEALTH_METRICS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HealthServiceFutureStub extends io.grpc.stub.AbstractStub<HealthServiceFutureStub> {
    private HealthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.hms.agent.grpc.HealthMetricsResponse> sendHealthMetrics(
        com.demo.hms.agent.grpc.HealthMetrics request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_HEALTH_METRICS, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_HEALTH_METRICS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_HEALTH_METRICS:
          serviceImpl.sendHealthMetrics((com.demo.hms.agent.grpc.HealthMetrics) request,
              (io.grpc.stub.StreamObserver<com.demo.hms.agent.grpc.HealthMetricsResponse>) responseObserver);
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

  private static abstract class HealthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.hms.agent.grpc.HMSService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthService");
    }
  }

  private static final class HealthServiceFileDescriptorSupplier
      extends HealthServiceBaseDescriptorSupplier {
    HealthServiceFileDescriptorSupplier() {}
  }

  private static final class HealthServiceMethodDescriptorSupplier
      extends HealthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HealthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthServiceFileDescriptorSupplier())
              .addMethod(METHOD_SEND_HEALTH_METRICS)
              .build();
        }
      }
    }
    return result;
  }
}
