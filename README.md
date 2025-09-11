
# Distributed-X

Pretty much the about section: A practically Distributed Social Media System having most large scale production features but distilled down to a minimalist blueprint that is easy for mentors to mentor with.

## Goals Of This Project
- 🔹 Using Vertical Slice Architecture for architecture level.
- 🔹 Using Spring MVC as a Web Framework.
- 🔹 Using Domain Driven Design (DDD) to implement all business processes in microservices.
- 🔹 Using Spring AMQP on top of Rabbitmq for Event Driven Architecture between our microservices.
- 🔹 Using gRPC for internal communication between our microservices.
- 🔹 Using CQRS implementation with a Mediator library.
- 🔹 Using Spring Data JPA for data persistence and ORM in write side with Postgres.
- 🔹 Using Spring Data Cassandra for data persistence and ORM in read side with CassandraDB.
- 🔹 Using Spring Data Neo4j for graph-based queries, social graph traversal, and recommendation logic.
- 🔹 Using Inbox Pattern for ensuring message idempotency for receiver and Exactly once Delivery.
- 🔹 Using Outbox Pattern for ensuring no message is lost and there is at At Least One Delivery.
- 🔹 Using Unit Testing for testing small units and mocking our dependencies with Mockito.
- 🔹 Using End-To-End Testing and Integration Testing for testing features with all dependencies using testcontainers.
- 🔹 Using Spring Validator and a Validation Pipeline Behavior on top of Mediator.
- 🔹 Using Springdoc Openapi for generating OpenAPI documentation in Spring Boot.
- 🔹 Using OpenTelemetry Collector for collecting Metrics, Tracings, and Structured Logs.
- 🔹 Using Kibana for Logging top of OpenTelemetry Collector.
- 🔹 Using Jaeger for Distributed Tracing top of OpenTelemetry Collector.
- 🔹 Using Prometheus and Grafana for monitoring top of OpenTelemetry Collector.
- 🔹 Using Keycloak for authentication and authorization based on OpenID-Connect and OAuth2.
- 🔹 Using Spring Cloud Gateway MVC as a Microservices' gateway.



## Roadmap

- Currently building User Service and Building Blocks (Non-Executable Library Module containing Mediator, Keycloak, Grafana etc...)

| Feature              | Dormant | In Progress | Completed |
|----------------------|---------|-------------|-----------|
| API Gateway          |        |   ✅          |           |
| Building Blocks      |         |      ✅       |           |
| Fanout Service         |    ✅     |             |           |
| Profile Service         |        |     ✅        |           |
| Storage Service         | ✅       |             |           |
| Timeline Service | ✅       |             |           |
| Tweet Service | ✅       |             |           |


