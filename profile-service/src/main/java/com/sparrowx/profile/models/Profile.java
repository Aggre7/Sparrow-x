package com.sparrowx.profile.models;


import buildingblocks.core.model.AggregateRoot;
import com.sparrowx.profile.valueobjects.*;
import com.sparrowx.profile.features.profile.createprofile.ProfileCreatedDomainEvent;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter(AccessLevel.PRIVATE)
public class Profile extends AggregateRoot<ProfileId> {

    UserName userName;
    FullName fullName;
    Password password;
    Email email;
    AvatarUrl avatarUrl;
    LocalDate joinDate;

    public Profile(ProfileId id,
                   UserName userName,
                   Email email,
                   AvatarUrl avatarUrl,
                   LocalDate joinDate,
                   LocalDateTime createdAt,
                   Long createdBy,
                   LocalDateTime lastModified,
                   Long lastModifiedBy,
                   Long version,
                   boolean isDeleted) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.joinDate = joinDate;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.version = version;
        this.isDeleted = isDeleted;
    }

    public Profile(ProfileId id,
                   UserName userName,
                   FullName fullName,
                   Email email,
                   Password password,
                   AvatarUrl avatarUrl) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }

    public static Profile create(ProfileId id,
                                 UserName userName,
                                 FullName fullName,
                                 Email email,
                                 Password password,
                                 AvatarUrl avatarUrl
                                 ) {
        var profile = new Profile(id, userName, fullName, email, password, avatarUrl);

        profile.addDomainEvent(new ProfileCreatedDomainEvent(
                profile.id.getValue(),
                profile.userName.getUserName(),
                profile.fullName.getFullName(),
                profile.email.getEmail()
        ));

        return profile;
    }

    public void update(UserId userId, UserName userName, AvatarUrl avatarUrl, boolean isDeleted) {
        this.userId = userId;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.isDeleted = isDeleted;
    }


}
