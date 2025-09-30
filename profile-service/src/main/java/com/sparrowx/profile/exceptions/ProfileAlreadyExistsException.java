package com.sparrowx.profile.exceptions;

import buildingblocks.core.exception.ConflictException;

public class ProfileAlreadyExistsException extends ConflictException {
    public ProfileAlreadyExistsException() {
        super("User already exists!");
    }
}

