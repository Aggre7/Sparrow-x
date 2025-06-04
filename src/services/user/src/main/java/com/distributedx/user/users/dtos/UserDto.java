package com.distributedx.user.users.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(
        UUID id,
        String username,
        String email,
        String fullName,
        String profilePictureUrl,
        String bio,
        LocalDateTime memberSince,
        int followerCount,
        int followingCount,
        int postCount
) { }