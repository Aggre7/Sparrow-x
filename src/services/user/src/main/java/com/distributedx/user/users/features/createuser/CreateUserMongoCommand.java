package com.distributedx.user.users.features.createuser;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.requests.Unit;

import java.util.UUID;

public record CreateUserMongoCommand(
        UUID id,
        String userName,
        String fullName,
        String email,
        String password,
        boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}
