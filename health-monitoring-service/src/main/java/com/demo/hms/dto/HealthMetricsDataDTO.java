package com.demo.hms.dto;

public class HealthMetricsDataDTO {

	private String status;

	private Integer memoryUsed;

	private Integer diskUsed;

	private Long timestamp;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMemoryUsed() {
		return memoryUsed;
	}

	public void setMemoryUsed(Integer memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	public Integer getDiskUsed() {
		return diskUsed;
	}

	public void setDiskUsed(Integer diskUsed) {
		this.diskUsed = diskUsed;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HealthMetricsDataDTO [status=").append(status).append(", memoryUsed=").append(memoryUsed)
				.append(", diskUsed=").append(diskUsed).append(", timestamp=").append(timestamp).append("]");
		return builder.toString();
	}

}
