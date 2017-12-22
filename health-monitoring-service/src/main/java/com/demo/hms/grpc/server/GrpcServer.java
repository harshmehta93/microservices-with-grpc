package com.demo.hms.grpc.server;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.hms.dto.HealthMetricsData;
import com.demo.hms.grpc.HealthMetrics;
import com.demo.hms.grpc.HealthMetricsResponse;
import com.demo.hms.grpc.HealthServiceGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

@Component
public class GrpcServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServer.class);

	@Value("${grpc.server.port}")
	private Integer grpcServerPort;

	private Server server;

	public void start() throws IOException {
		server = ServerBuilder.forPort(grpcServerPort).addService(new CameraServiceImpl()).build().start();
		LOGGER.info("");
		LOGGER.info("=====================================");
		LOGGER.info("-> GRPC server started on port {}.", grpcServerPort);
		LOGGER.info("=====================================");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
				GrpcServer.this.stop();
				LOGGER.error("*** server shut down");
			}
		});
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon
	 * threads.
	 */
	public void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	static class CameraServiceImpl extends HealthServiceGrpc.HealthServiceImplBase {

		@Override
		public void sendHealthMetrics(HealthMetrics healthMetrics,
				StreamObserver<HealthMetricsResponse> responseObserver) {
			processHealthMetrics(healthMetrics);
			HealthMetricsResponse reply = HealthMetricsResponse.newBuilder().setStatus("OK").build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		}

		private void processHealthMetrics(HealthMetrics healthMetrics) {
			LOGGER.info("Received health metrics -> {}", healthMetrics);
			HealthMetricsData.addMetrics(healthMetrics);
		}
	}
}
