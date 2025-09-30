package com.sparrowx.profile.features.profile.createprofile;

import buildingblocks.core.event.DomainEvent;

import java.util.UUID;

public record ProfileCreatedDomainEvent(
        UUID id,
        String userName,
        String fullName,
        String email,
        String password,
        boolean isDeleted) implements DomainEvent {
}