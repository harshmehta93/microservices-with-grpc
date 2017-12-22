package com.demo.hms.agent.service;

import java.util.Random;

import com.demo.hms.agent.enums.Status;

public class GatherHealthMetrics {

	public static long getTimeStamp() {
		return System.currentTimeMillis();
	}

	public static String getStatus() {
		boolean randomFlag = new Random().nextBoolean();
		return (randomFlag) ? Status.UP.name() : Status.DOWN.name();
	}

	public static int getDisk() {
		return new Random().nextInt(100);
	}

	public static int getMemoryUsed() {
		return new Random().nextInt(100);
	}
}
