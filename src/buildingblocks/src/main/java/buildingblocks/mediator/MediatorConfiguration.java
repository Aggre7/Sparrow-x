package buildingblocks.mediator;

import buildingblocks.mediator.abstractions.IMediator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnMissingBean({IMediator.class})
@ConditionalOnClass({IMediator.class})
@ConditionalOnProperty(prefix = "mediator", name = "enabled", havingValue = "true", matchIfMissing = true)
@Configuration
public class MediatorConfiguration {
    MediatorConfiguration() {}

    @Bean
    @ConditionalOnMissingBean
    public IMediator mediator(ApplicationContext applicationContext) {
        return new Mediator(applicationContext);
    }
}
