# Microservices with gRPC

This project is the small scale application of health-monitoring-system which gathers health-metrics from HMS agent and exposes them to the outside world via REST API. Primary purpose of this project is to get the idea of how gRPC framework can be used with microservices.

This project consists following components:
- Health Monitoring Service:
- This is a microservice developed in Spring Boot, which captures the health-metrics data sent by health-monitoring-agent and exposes them to be consumed by outside world via REST API.
- It uses gRPC server component to receive the health-metrics from HMS agent.

- Health Monitoring Agent:
- This is also a microservice developed in Spring Boot, which gathers various health-metrics of server on which its deployed and sends it to the Health Monitoring Service for processing.
- It uses gRPC client component to send the data to Health Monitoring Service.