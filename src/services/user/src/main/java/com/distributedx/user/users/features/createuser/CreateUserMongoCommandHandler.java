package com.distributedx.user.users.features.createuser;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.requests.Unit;
import com.distributedx.user.data.mongo.documents.UserDocument;
import com.distributedx.user.data.mongo.repositories.UserReadRepository;
import com.distributedx.user.users.exceptions.UserAlreadyExistException;
import com.distributedx.user.users.features.Mappings;
import org.springframework.stereotype.Service;

@Service
public class CreateUserMongoCommandHandler implements ICommandHandler<CreateUserMongoCommand, Unit> {

    private final UserReadRepository UserReadRepository;

    public CreateUserMongoCommandHandler(UserReadRepository UserReadRepository) {
        this.UserReadRepository = UserReadRepository;
    }

    public Unit handle(CreateUserMongoCommand command) {

        UserDocument userDocument = Mappings.toUserDocument(command);

        var UserExist = UserReadRepository.findUserByUserIdAndIsDeletedFalse(userDocument.getUserId());

        if (UserExist != null) {
            throw new UserAlreadyExistException();
        }

        UserReadRepository.save(userDocument);

        return Unit.VALUE;
    }
}

