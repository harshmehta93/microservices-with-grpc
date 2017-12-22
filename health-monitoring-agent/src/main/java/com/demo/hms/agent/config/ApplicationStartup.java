package com.demo.hms.agent.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.demo.hms.agent.grpc.HealthMetricsResponse;
import com.demo.hms.agent.grpc.client.GrpcClient;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);

	@Value("${health.service.host}")
	private String healthServiceHost;

	@Value("${grpc.server.port}")
	private Integer grpcServerPort;

	@Value("${publish.health.metrics}")
	private Boolean publishHealthMetrics;

	@Value("${publish.interval}")
	private Integer interval;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		LOGGER.info("publishHealthMetrics property set to -> {}", publishHealthMetrics);
		LOGGER.info("Time interval to publish health-metrics in millis is -> {}", interval * 1000);
		publishHealthMetrics();
	}

	public void publishHealthMetrics() {
		if (publishHealthMetrics) {
			try {
				long intervalInMillis = interval * 1000;
				GrpcClient client = new GrpcClient(healthServiceHost, grpcServerPort);
				HealthMetricsResponse response = client.sendHealthMetricsData();
				String responseString = JsonFormat.printer().print(response);
				LOGGER.info("Response received from health-service -> {}", responseString);
				client.shutdown();
				Thread.sleep(intervalInMillis);
				publishHealthMetrics();
			} catch (InvalidProtocolBufferException | InterruptedException e) {
				LOGGER.error("GRPC exception. Exception -> {}", e);
			}
		}
	}

}
