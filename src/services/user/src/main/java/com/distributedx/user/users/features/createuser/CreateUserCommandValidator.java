package com.distributedx.user.users.features.createuser;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CreateUserCommandValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CreateUserCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUserCommand command = (CreateUserCommand) target;

        if (command == null) {
            errors.rejectValue("id", "id.required", "User ID is required");
        }

        if (command.userName() == null) {
            errors.rejectValue("userName", "userName.required", "User Name is required");
        }

        if (command.fullName() == null) {
            errors.rejectValue("fullName", "fullName.required", "Full Name is required");
        }

        if (command.email() == null ) {
            errors.rejectValue("email", "email.required", "Email is required");
        }

        if (command.password() == null ) {
            errors.rejectValue("password", "password.required", "Email is required");
        }
    }

}
