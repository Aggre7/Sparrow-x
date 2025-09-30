package com.sparrowx.profile.valueobjects;

import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class Password {
    private char[] password;

    public Password(char[] value) {
        ValidationUtils.notBeNullOrEmpty(value);
        this.password = value;
    }
}




