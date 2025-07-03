package com.distributedx.user;

import buildingblocks.contracts.user.UserCreated;
import buildingblocks.core.event.DomainEvent;
import buildingblocks.core.event.EventMapper;
import buildingblocks.core.event.IntegrationEvent;
import buildingblocks.core.event.InternalCommand;
import com.distributedx.user.users.features.createuser.CreateUserMongoCommand;
import com.distributedx.user.users.features.createuser.UserCreatedDomainEvent;
import org.springframework.stereotype.Component;

@Component
public class EventMapperImpl implements EventMapper {
    @Override
    public IntegrationEvent MapToIntegrationEvent(DomainEvent event) {
        return switch (event) {
            case UserCreatedDomainEvent e -> new UserCreated(e.id());
            default -> null;
        };
    }

    @Override
    public InternalCommand MapToInternalCommand(DomainEvent event) {
        return switch (event) {
            case UserCreatedDomainEvent e -> new CreateUserMongoCommand(e.id(), e.userName(), e.fullName(), e.email(), e.password(), e.isDeleted());
            default -> null;
        };
    }
}
