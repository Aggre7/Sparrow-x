package com.sparrowx.profile.exceptions;

import buildingblocks.core.exception.ValidationException;

public class InvalidProfileDataException extends ValidationException {
    public InvalidProfileDataException(String message) {
        super(message);
    }
}
