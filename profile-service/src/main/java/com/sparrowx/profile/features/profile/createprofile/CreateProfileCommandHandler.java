package com.sparrowx.profile.features.profile.createprofile;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import com.sparrowx.profile.data.postgres.entities.ProfileEntity;
import com.sparrowx.profile.data.postgres.repositories.ProfileRepository;
import com.sparrowx.profile.dtos.ProfileDto;
import com.sparrowx.profile.exceptions.ProfileAlreadyExistsException;
import com.sparrowx.profile.features.Mappings;
import com.sparrowx.profile.mappers.ProfileMapper;
import com.sparrowx.profile.models.Profile;
import com.sparrowx.profile.valueobjects.*;

import org.springframework.stereotype.Service;

@Service
public class CreateProfileCommandHandler implements ICommandHandler<CreateProfileCommand, ProfileDto> {

    private final ProfileRepository profileRepository;

    public CreateProfileCommandHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileDto handle(CreateProfileCommand command) {

        profileRepository.findByUserNameAndIsDeletedFalse(new UserName(command.userName()))
        .ifPresent(profile -> {throw new ProfileAlreadyExistsException();});

        Profile profileAggregate = Profile.create(
                new ProfileId(command.id()),
                new UserName(command.userName()),
                new Email(command.email())

        );

        ProfileEntity profileEntity = ProfileMapper.toProfileEntity(profileAggregate);

        ProfileEntity createdProfile = profileRepository.save(profileEntity);

        return ProfileMapper.toProfileDto(createdProfile);
    }
}
