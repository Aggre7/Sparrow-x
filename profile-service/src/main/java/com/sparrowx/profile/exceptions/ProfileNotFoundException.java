package com.sparrowx.profile.exceptions;

import buildingblocks.core.exception.NotFoundException;

public class ProfileNotFoundException extends NotFoundException {
    public ProfileNotFoundException(String message) {
        super(message);
    }
}
