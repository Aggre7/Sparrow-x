package com.distributedx.user.users.dtos;

import java.util.UUID;

public record UserDto(
        UUID id,
        String userName,
        String fullName,
        String email
) { }