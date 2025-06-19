package com.distributedx.user;

import buildingblocks.jpa.JpaConfiguration;
import buildingblocks.logger.LoggerConfiguration;
import buildingblocks.mediator.MediatorConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        JpaConfiguration.class,
        LoggerConfiguration.class,
        FlywayAutoConfiguration.FlywayConfiguration.class,
        MediatorConfiguration.class
})
public class UserConfigurations {
}
