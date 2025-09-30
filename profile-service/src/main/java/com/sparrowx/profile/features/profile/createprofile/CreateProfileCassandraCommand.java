package com.sparrowx.profile.features.profile.createprofile;


import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.requests.Unit;

import java.util.UUID;

public record CreateProfileCassandraCommand(
        UUID id,
        String userName,
        String fullName,
        String email,
        String avatarUrl
) implements ICommand<Unit>, InternalCommand { }



