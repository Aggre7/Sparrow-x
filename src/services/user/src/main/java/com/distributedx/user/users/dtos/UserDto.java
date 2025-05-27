package com.distributedx.user.users.dtos;
import com.distributedx.user.users.enums.UserType;
import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        UserType userType,
        int age
) { }