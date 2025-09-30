package com.sparrowx.profile.models;

import buildingblocks.core.model.AggregateRoot;
import com.sparrowx.profile.valueobjects.*;
import com.sparrowx.profile.features.createuser.UserCreatedDomainEvent;
import com.sparrowx.profile.valueobjects.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter(AccessLevel.PRIVATE)
public class User extends AggregateRoot<UserId> {
    UserName userName;
    FullName fullName;
    Email email;
    Password password;

    public User(UserId userId, UserName userName, FullName fullName, Email email, Password password, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
       this.id = userId;
       this.userName = userName;
       this.fullName = fullName;
       this.email = email;
       this.password = password;
       this.createdAt = createdAt;
       this.createdBy = createdBy;
       this.lastModified = lastModified;
       this.lastModifiedBy = lastModifiedBy;
       this.version = version;
       this.isDeleted = isDeleted;
    }

    public User(UserId userId, UserName userName, FullName fullName, Email email, Password password) {
        this.id = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public static User create(UserId userId, UserName userName, FullName fullName, Email email, Password password) {
        var user = new User(userId, userName, fullName, email, password);

        user.addDomainEvent(new UserCreatedDomainEvent(
                user.id.getUserId(),
                user.userName.getUserName(),
                user.fullName.getFullName(),
                user.email.getEmail(),
                user.password.getPassword(),
                false
        ));

        return user;
    }
}
