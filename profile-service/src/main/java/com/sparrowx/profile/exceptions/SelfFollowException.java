package com.sparrowx.profile.exceptions;

import buildingblocks.core.exception.BadRequestException;

public class SelfFollowException extends BadRequestException {
    public SelfFollowException(String message) {
        super(message);
    }
}
