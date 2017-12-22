package com.demo.hms.dto;

import java.util.ArrayList;
import java.util.List;

import com.demo.hms.grpc.HealthMetrics;

public class HealthMetricsData {

	private HealthMetricsData() {
	}

	private static List<HealthMetrics> healthMetricsData = new ArrayList<>();

	public static void addMetrics(HealthMetrics healthMetrics) {
		healthMetricsData.add(healthMetrics);
	}

	public static List<HealthMetrics> getHealthMetrics() {
		return healthMetricsData;
	}
}
