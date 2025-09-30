package buildingblocks.contracts.profile;

import buildingblocks.core.event.IntegrationEvent;
import java.util.UUID;

public record FollowCreated(
        UUID followerId,
        UUID followeeId,
        long createdAt
) implements IntegrationEvent {
}

