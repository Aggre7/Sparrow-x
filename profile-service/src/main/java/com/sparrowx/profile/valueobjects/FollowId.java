package com.sparrowx.profile.valueobjects;

import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class FollowId {

    private UUID value;

    public FollowId(UUID value) {
        ValidationUtils.notBeNullOrEmpty(value);
        this.value = value;
    }
}
