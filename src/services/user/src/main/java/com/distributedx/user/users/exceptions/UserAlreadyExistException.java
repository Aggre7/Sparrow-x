package com.distributedx.user.users.exceptions;

import buildingblocks.core.exception.ConflictException;

public class UserAlreadyExistException extends ConflictException {
    public UserAlreadyExistException() {
        super("User already exists!");
    }
}

