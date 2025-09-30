package com.sparrowx.profile.dtos;

import java.util.UUID;

public record UserDto(
        UUID id,
        String userName,
        String fullName,
        String email
) { }