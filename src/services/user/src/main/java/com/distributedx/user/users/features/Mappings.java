package com.distributedx.user.users.features;

import com.distributedx.user.data.jpa.entities.UserEntity;
import com.distributedx.user.data.mongo.documents.UserDocument;
import com.distributedx.user.users.dtos.UserDto;
import com.distributedx.user.users.features.createuser.CreateUserCommand;
import com.distributedx.user.users.features.createuser.CreateUserMongoCommand;
import com.distributedx.user.users.features.createuser.CreateUserRequestDto;
import com.distributedx.user.users.models.User;
import com.github.f4b6a3.uuid.UuidCreator;


public final class Mappings {


    public static UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getId().getUserId(),
                user.getUserName(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getCreatedBy(),
                user.getLastModified(),
                user.getLastModifiedBy(),
                user.getVersion(),
                user.isDeleted()
        );
    }

    public static CreateUserCommand toCreateUserCommand(CreateUserRequestDto userRequestDto) {
        return new CreateUserCommand(
                UuidCreator.getTimeOrderedEpoch(),
                userRequestDto.userName(),
                userRequestDto.fullName(),
                userRequestDto.email(),
                userRequestDto.password()
        );
    }

    public static UserDto toUserDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getUserName().getUserName(),
                userEntity.getFullName().getFullName(),
                userEntity.getEmail().getEmail());
    }

    public static UserDocument toUserDocument(CreateUserMongoCommand createUserMongoCommand) {
        return new UserDocument(
                createUserMongoCommand.id(),
                createUserMongoCommand.userName(),
                createUserMongoCommand.fullName(),
                createUserMongoCommand.email(),
                createUserMongoCommand.password(),
                createUserMongoCommand.isDeleted()
        );
    }

    public static UserDocument toUserDocument(UserEntity UserEntity) {
        return new UserDocument(
                UserEntity.getId(),
                UserEntity.getUserName().getUserName(),
                UserEntity.getFullName().getFullName(),
                UserEntity.getEmail().getEmail(),
                UserEntity.getPassword().getPassword(),
                UserEntity.isDeleted()
        );
    }

    public static UserDto toUserDto(UserDocument userDocument) {
        return new UserDto(
                userDocument.getUserId(),
                userDocument.getUserName(),
                userDocument.getFullName(),
                userDocument.getEmail()
        );
    }

}