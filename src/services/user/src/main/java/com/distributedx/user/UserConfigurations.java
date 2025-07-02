package com.distributedx.user;

import buildingblocks.core.event.EventDispatcherConfiguration;
import buildingblocks.jpa.JpaConfiguration;
import buildingblocks.keycloak.KeycloakConfiguration;
import buildingblocks.logger.LoggerConfiguration;
import buildingblocks.mediator.MediatorConfiguration;
import buildingblocks.mongo.MongoConfiguration;
import buildingblocks.otel.collector.OtelCollectorConfiguration;
import buildingblocks.outboxprocessor.PersistMessageProcessorConfiguration;
import buildingblocks.problemdetails.CustomProblemDetailsHandler;
import buildingblocks.swagger.SwaggerConfiguration;
import buildingblocks.threadpool.ThreadPoolConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        JpaConfiguration.class,
        LoggerConfiguration.class,
        FlywayAutoConfiguration.FlywayConfiguration.class,
        MediatorConfiguration.class,
        KeycloakConfiguration.class,
        MongoConfiguration.class,
        CustomProblemDetailsHandler.class,
        EventDispatcherConfiguration.class,
        ThreadPoolConfiguration.class,
        PersistMessageProcessorConfiguration.class,
        SwaggerConfiguration.class,
        OtelCollectorConfiguration.class,
})
public class UserConfigurations {
}
