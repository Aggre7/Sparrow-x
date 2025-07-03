package com.distributedx.user.users.features.createuser;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import com.distributedx.user.data.jpa.entities.UserEntity;
import com.distributedx.user.data.jpa.repositories.UserRepository;
import com.distributedx.user.users.dtos.UserDto;
import com.distributedx.user.users.exceptions.UserAlreadyExistException;
import com.distributedx.user.users.features.Mappings;
import com.distributedx.user.users.models.User;
import com.distributedx.user.users.valueobjects.*;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler implements ICommandHandler<CreateUserCommand, UserDto> {
    private final UserRepository userRepository;

    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto handle(CreateUserCommand command) {

        UserEntity existUser = userRepository.findUserByEmailAndIsDeletedFalse(new Email(command.email()));
        if (existUser != null) {
         throw new UserAlreadyExistException();
        }

        User userAggregate = User.create(
                new UserId(command.id()),
                new UserName(command.userName()),
                new FullName(command.fullName()),
                new Email(command.email()),
                new Password(command.password())
        );

        UserEntity userEntity = Mappings.toUserEntity(userAggregate);

        UserEntity createdUser = userRepository.save(userEntity);

        return Mappings.toUserDto(createdUser);
    }
}
