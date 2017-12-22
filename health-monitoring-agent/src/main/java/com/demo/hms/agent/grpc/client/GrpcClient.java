package com.demo.hms.agent.grpc.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.hms.agent.enums.Status;
import com.demo.hms.agent.grpc.HealthMetrics;
import com.demo.hms.agent.grpc.HealthMetricsResponse;
import com.demo.hms.agent.grpc.HealthServiceGrpc;
import com.demo.hms.agent.service.GatherHealthMetrics;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GrpcClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(GrpcClient.class);

	private final ManagedChannel channel;
	private final HealthServiceGrpc.HealthServiceBlockingStub blockingStub;

	/**
	 * Construct client connecting to HelloWorld server at {@code host:port}.
	 */
	public GrpcClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build());
	}

	/**
	 * Construct client for accessing RouteGuide server using the existing channel.
	 */
	GrpcClient(ManagedChannel channel) {
		this.channel = channel;
		this.blockingStub = HealthServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public HealthMetricsResponse sendHealthMetricsData() {
		HealthMetricsResponse response = null;
		try {
			HealthMetrics request = null;
			String status = GatherHealthMetrics.getStatus();
			long timestamp = GatherHealthMetrics.getTimeStamp();
			if (Status.UP.name().equals(status)) {
				Integer memoryUsed = GatherHealthMetrics.getMemoryUsed();
				Integer diskUsed = GatherHealthMetrics.getDisk();
				request = HealthMetrics.newBuilder().setDiskUsed(diskUsed).setMemoryUsed(memoryUsed).setStatus(status)
						.setTimestamp(timestamp).build();
			} else {
				request = HealthMetrics.newBuilder().setStatus(status).setTimestamp(timestamp).build();
			}
			response = blockingStub.sendHealthMetrics(request);
		} catch (StatusRuntimeException e) {
			LOGGER.error("RPC failed: {0}", e);
		}
		return response;
	}

}
