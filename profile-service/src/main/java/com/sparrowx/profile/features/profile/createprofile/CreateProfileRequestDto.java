package com.sparrowx.profile.features.profile.createprofile;

public record CreateProfileRequestDto(
        String userName,
        String fullName,
        String email,
        String avatarUrl
) { }

