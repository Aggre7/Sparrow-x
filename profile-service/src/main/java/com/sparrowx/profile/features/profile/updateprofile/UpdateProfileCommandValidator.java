package com.sparrowx.profile.features.profile.updateprofile;

import com.sparrowx.profile.enums.ProfileStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.EnumSet;

@Component
public class UpdateProfileCommandValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UpdateProfileCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateProfileCommand command = (UpdateProfileCommand) target;

        if (command.id() == null) {
            errors.rejectValue("id", "id.required", "Profile ID is required");
        }

        if (command.name() == null || command.name().trim().isEmpty()) {
            errors.rejectValue("name", "name.required", "Name is required");
        }

        if (command.avatarUrl() != null && !command.avatarUrl().startsWith("http")) {
            errors.rejectValue("avatarUrl", "avatarUrl.invalid", "Avatar URL must be a valid URL");
        }


    }

    private boolean isValidStatus(ProfileStatus status) {
        return EnumSet.of(
                ProfileStatus.Active,
                ProfileStatus.Suspended,
                ProfileStatus.Deleted
        ).contains(status);
    }
}
