package com.sparrowx.profile.dtos;

import com.sparrowx.profile.valueobjects.UserName;

import java.time.LocalDate;
import java.util.UUID;

public record ProfileDto(
        UUID id,
        String email,
        UserName username,
        String avatarUrl,
        LocalDate joinDate
) { }
