package buildingblocks.contracts.profile;

import buildingblocks.core.event.IntegrationEvent;
import java.util.UUID;

public record ProfileUpdated(
        UUID profileId,
        String displayName,
        String bio,
        String avatarUrl,
        long updatedAt
) implements IntegrationEvent {
}
