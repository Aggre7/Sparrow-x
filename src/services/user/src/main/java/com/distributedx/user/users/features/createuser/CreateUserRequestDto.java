package com.distributedx.user.users.features.createuser;

public record CreateUserRequestDto(
        String userName,
        String fullName,
        String email,
        String password){
}

