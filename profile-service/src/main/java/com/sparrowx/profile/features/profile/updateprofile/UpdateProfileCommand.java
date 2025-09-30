package com.sparrowx.profile.features.profile.updateprofile;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import com.sparrowx.profile.dtos.ProfileDto;
import java.util.UUID;

public record UpdateProfileCommand(
        UUID id,
        String name,
        String bio,
        String avatarUrl
) implements ICommand<ProfileDto>, InternalCommand {
}
