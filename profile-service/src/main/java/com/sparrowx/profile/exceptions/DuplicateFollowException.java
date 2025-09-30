package com.sparrowx.profile.exceptions;

import buildingblocks.core.exception.ConflictException;

public class DuplicateFollowException extends ConflictException {
    public DuplicateFollowException(String message) {
        super(message);
    }
}
