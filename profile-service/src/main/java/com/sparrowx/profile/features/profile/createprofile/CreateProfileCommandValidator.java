package com.sparrowx.profile.features.profile.createprofile;
import buildingblocks.utils.validation.ValidationUtils;

public class CreateProfileCommandValidator {
    public static void validate(CreateProfileCommand command) {
        ValidationUtils.notBeNullOrEmpty(command.id(), "Profile ID is required");
        ValidationUtils.notBeNullOrEmpty(command.email(), "Email is required");
        ValidationUtils.notBeNullOrEmpty(command.userName(), "Username is required");
        // Optional: length/format checks (email regex, username length, etc.)
    }
}

