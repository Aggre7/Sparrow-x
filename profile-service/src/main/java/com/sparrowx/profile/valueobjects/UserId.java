package com.sparrowx.profile.valueobjects;

import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class UserId {
    private UUID userId;

    public UserId(UUID value) {
        ValidationUtils.notBeNullOrEmpty(value);

        this.userId = value;
    }
}
