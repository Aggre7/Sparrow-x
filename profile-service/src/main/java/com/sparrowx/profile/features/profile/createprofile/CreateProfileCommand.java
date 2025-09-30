package com.sparrowx.profile.features.profile.createprofile;


import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import com.sparrowx.profile.dtos.ProfileDto;

import java.util.UUID;

public record CreateProfileCommand(
        UUID id,
        String email,
        String userName,
        String fullName,
        String avatarUrl
) implements ICommand<ProfileDto>, InternalCommand { }
