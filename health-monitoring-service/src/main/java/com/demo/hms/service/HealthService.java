package com.demo.hms.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hms.dto.HealthMetricsData;
import com.demo.hms.dto.HealthMetricsDataDTO;
import com.demo.hms.grpc.HealthMetrics;
import com.demo.hms.utils.Utils;

@Service
public class HealthService {

	@Autowired
	private Utils utils;

	public List<HealthMetricsDataDTO> getHealthMetricsData() {
		List<HealthMetricsDataDTO> healthMetricsDtoList = new ArrayList<>();
		List<HealthMetrics> healthMetricsList = HealthMetricsData.getHealthMetrics();
		for (HealthMetrics healthMetric : healthMetricsList) {
			HealthMetricsDataDTO healthMetricsDto = new HealthMetricsDataDTO();
			utils.copyNotNullProperties(healthMetric, healthMetricsDto);
			healthMetricsDtoList.add(healthMetricsDto);
		}
		return healthMetricsDtoList.stream().sorted(Comparator.comparing(HealthMetricsDataDTO::getTimestamp).reversed())
				.collect(Collectors.toList());
	}
}
