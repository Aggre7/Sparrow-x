package com.sparrowx.profile.mappers;

import buildingblocks.core.event.DomainEvent;
import buildingblocks.core.event.EventMapper;
import buildingblocks.core.event.IntegrationEvent;
import buildingblocks.core.event.InternalCommand;
import com.sparrowx.profile.features.profile.createprofile.CreateProfileCommand;
import com.sparrowx.profile.features.profile.createprofile.ProfileCreatedDomainEvent;
import com.sparrowx.profile.contracts.ProfileCreated;
import org.springframework.stereotype.Component;

@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public IntegrationEvent MapToIntegrationEvent(DomainEvent event) {
        return switch (event) {
            case ProfileCreatedDomainEvent e -> new ProfileCreated(e.profileId(), e.userName(), e.email(), e.joinDate());
            default -> null;
        };
    }

    @Override
    public InternalCommand MapToInternalCommand(DomainEvent event) {
        return switch (event) {
            case ProfileCreatedDomainEvent e -> new CreateProfileCommand(
                    e.profileId(), e.userName(), e.email(), e.joinDate(), e.isDeleted()
            );
            default -> null;
        };
    }
}
