package com.distributedx.user.users.features;

import com.distributedx.user.users.features.createuser.CreateUserCommand;
import com.distributedx.user.users.features.createuser.CreateUserRequestDto;
import com.github.f4b6a3.uuid.UuidCreator;


public final class Mappings {


    public static CreateUserCommand toCreateUserCommand(CreateUserRequestDto userRequestDto) {
        return new CreateUserCommand(
                UuidCreator.getTimeOrderedEpoch(),
                userRequestDto.userName(),
                userRequestDto.email(),
                userRequestDto.password(),
                userRequestDto.fullName()
        );
    }



}