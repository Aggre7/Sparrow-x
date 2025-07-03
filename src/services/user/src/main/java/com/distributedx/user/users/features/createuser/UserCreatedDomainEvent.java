package com.distributedx.user.users.features.createuser;

import buildingblocks.core.event.DomainEvent;

import java.util.UUID;

public record UserCreatedDomainEvent(
        UUID id,
        String userName,
        String fullName,
        String email,
        String password,
        boolean isDeleted) implements DomainEvent {
}