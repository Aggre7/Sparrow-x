package com.sparrowx.profile.dtos;

import java.util.UUID;

public record FollowDto(
        UUID id,
        UUID followerId,
        UUID followeeId,
        long createdAt
) { }
