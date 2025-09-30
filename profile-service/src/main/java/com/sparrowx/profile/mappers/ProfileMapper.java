package com.sparrowx.profile.mappers;

import com.sparrowx.profile.data.cassandra.tables.ProfileTable;
import com.sparrowx.profile.dtos.ProfileDto;
import com.sparrowx.profile.data.postgres.entities.ProfileEntity;
import com.sparrowx.profile.features.profile.createprofile.CreateProfileCassandraCommand;
import com.sparrowx.profile.features.profile.createprofile.CreateProfileCommand;
import com.sparrowx.profile.features.profile.createprofile.CreateProfileRequestDto;
import com.sparrowx.profile.features.profile.updateprofile.UpdateProfileCassandraCommand;
import com.sparrowx.profile.models.Profile;
import com.sparrowx.profile.valueobjects.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProfileMapper {




    public ProfileDto toDto(Profile profile) {
        return new ProfileDto(
                profile.getId().getValue(),
                profile.getEmail().getEmail(),
                profile.getUserName().getUserName(),
                profile.getAvatarUrl() != null ? profile.getAvatarUrl().getValue() : null,
                profile.getJoinDate()
        );
    }

    public Profile toDomain(ProfileEntity entity) {
        return new Profile(
                new ProfileId(entity.getId()),
                new UserName(entity.getUsername()),
                new Email(entity.getEmail()),
                entity.getJoinDate()
        );
    }

    public ProfileEntity toProfileEntity(Profile profileAggregate) {
        ProfileEntity entity = new ProfileEntity();
        entity.setId(profileAggregate.getId().getValue());
        entity.setUserName(profileAggregate.getUserName());
        entity.setEmail(profileAggregate.getEmail());
        entity.setName(profileAggregate.getName());
        entity.setAvatarUrl(profileAggregate.getAvatarUrl());
        entity.setStatus(profileAggregate.getStatus());
        entity.setDeleted(profileAggregate.isDeleted());
        entity.setCreatedAt(profileAggregate.getCreatedAt());
        entity.setUpdatedAt(profileAggregate.getUpdatedAt());
        return entity;
    }

    public static ProfileDto toProfileDto(ProfileEntity entity) {
        if (entity == null) {
            return null;
        }

        return new ProfileDto(
                entity.getId(),
                entity.getUserName() != null ? entity.getUserName().getValue() : null,
                entity.getEmail() != null ? entity.getEmail().getValue() : null,
                entity.getName(),
                entity.getBio(),
                entity.getAvatarUrl(),
                entity.getBannerUrl(),
                entity.getLocation(),
                entity.getWebsite(),
                entity.getStatus(),
                entity.isDeleted(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }


    public ProfileEntity toEntity(Profile profile) {
        ProfileEntity entity = new ProfileEntity();
        entity.setId(profile.getId().getValue());
        entity.setUsername(profile.getUserName().getValue());
        entity.setEmail(profile.getEmail().getValue());
        entity.setJoinDate(profile.getJoinDate());
        // optional fields

        entity.setAvatarUrl(profile.getAvatarUrl() != null ? profile.getAvatarUrl().getValue() : null);
        return entity;
    }

    public static ProfileTable toProfileTable(CreateProfileCassandraCommand command) {
        return ProfileTable.builder()
                .id(command.id())
                .userName(command.userName())
                .fullName(command.fullName())
                .email(command.email())
                .avatarUrl(command.avatarUrl())
                .build();
    }

    public static ProfileTable toProfileTable(UUID id, UpdateProfileCassandraCommand command) {
        ProfileTable table = new ProfileTable();
        table.setId(id);
        table.setName(command.name());
        table.setAvatarUrl(command.avatarUrl());
        table.setStatus(command.status());
        table.setDeleted(command.isDeleted());
        return table;
    }

    public static CreateProfileCommand toCreateProfileCommand(CreateProfileRequestDto requestDto) {
        return new CreateProfileCommand(
                UUID.randomUUID(),
                requestDto.userName(),
                requestDto.fullName(),
                requestDto.email(),
                requestDto.avatarUrl()
        );
    }


}
