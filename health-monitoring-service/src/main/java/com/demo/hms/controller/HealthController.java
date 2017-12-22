package com.demo.hms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hms.dto.HealthMetricsDataDTO;
import com.demo.hms.service.HealthService;

@RestController
@RequestMapping(value = "/api/v1")
public class HealthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

	@Autowired
	private HealthService healthService;

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<List<HealthMetricsDataDTO>> listCameras() {
		ResponseEntity<List<HealthMetricsDataDTO>> response = null;
		try {
			List<HealthMetricsDataDTO> healthMetricsDtoList = healthService.getHealthMetricsData();
			response = new ResponseEntity<>(healthMetricsDtoList, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("GRPC exception occurred. Exception: {}", e);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
