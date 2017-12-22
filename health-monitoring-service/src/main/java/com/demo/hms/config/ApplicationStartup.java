package com.demo.hms.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.demo.hms.grpc.server.GrpcServer;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);

	@Autowired
	private GrpcServer grpcServer;

	@Autowired
	private ApplicationContext context;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			grpcServer.start();
			grpcServer.blockUntilShutdown();
		} catch (IOException | InterruptedException e) {
			LOGGER.error("-> GRPC server could not be started on application startup. Exception: {}", e);
			SpringApplication.exit(context);
		}
	}

}
