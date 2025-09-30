package buildingblocks.contracts.user;

import buildingblocks.core.event.IntegrationEvent;

import java.util.UUID;

public record UserCreated(UUID Id) implements IntegrationEvent {
}
