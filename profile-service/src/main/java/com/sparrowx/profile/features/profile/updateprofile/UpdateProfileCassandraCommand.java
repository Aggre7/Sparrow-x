package com.sparrowx.profile.features.profile.updateprofile;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.requests.Unit;
import com.sparrowx.profile.enums.ProfileStatus;
import java.util.UUID;

public record UpdateProfileCassandraCommand(
        UUID id,
        String user,
        String bio,
        String avatarUrl,
        ProfileStatus status,
        boolean isDeleted
) implements ICommand<Unit>, InternalCommand {
}
