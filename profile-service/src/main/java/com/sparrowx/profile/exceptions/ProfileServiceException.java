package com.sparrowx.profile.exceptions;

import buildingblocks.core.exception.CustomException;

public class ProfileServiceException extends CustomException {
    public ProfileServiceException(String message) {
        super(message);
    }

    public ProfileServiceException(String message, Throwable cause) {
        super(message, (Exception) cause);
    }
}
