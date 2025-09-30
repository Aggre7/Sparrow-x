package com.sparrowx.profile.features.profile.updateprofile;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.requests.Unit;
import com.sparrowx.profile.data.cassandra.tables.ProfileTable;
import com.sparrowx.profile.data.cassandra.repositories.ProfileCassandraRepository;
import com.sparrowx.profile.exceptions.ProfileNotFoundException;
import com.sparrowx.profile.mappers.ProfileMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfileCassandraCommandHandler implements ICommandHandler<UpdateProfileCassandraCommand, Unit> {

    private final ProfileCassandraRepository profileCassandraRepository;

    public UpdateProfileCassandraCommandHandler(ProfileCassandraRepository profileCassandraRepository) {
        this.profileCassandraRepository = profileCassandraRepository;
    }

    @Override
    public Unit handle(UpdateProfileCassandraCommand command) {
        // Look up profile in Cassandra by ID
        ProfileTable existingProfile = profileCassandraRepository.findById(command.id())
                .orElseThrow(()-> new ProfileNotFoundException("Profile" + command.id() + " not found"));

        // Map updated data into a new table object
        ProfileTable updatedProfile = ProfileMapper.toProfileTable(existingProfile.getId(), command);

        // Save updated profile back to Cassandra
        profileCassandraRepository.save(updatedProfile);

        return Unit.VALUE;
    }
}
