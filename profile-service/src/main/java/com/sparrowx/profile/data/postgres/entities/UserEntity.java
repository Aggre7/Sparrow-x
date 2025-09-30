package com.sparrowx.profile.data.postgres.entities;

import buildingblocks.core.model.BaseEntity;
import com.sparrowx.profile.valueobjects.Email;
import com.sparrowx.profile.valueobjects.FullName;
import com.sparrowx.profile.valueobjects.Password;
import com.sparrowx.profile.valueobjects.UserName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity extends BaseEntity<UUID> {

    @Embedded
    private UserName userName;
    @Embedded
    private FullName fullName;
    @Embedded
    private Email email;
    @Embedded
    private Password password;




    public UserEntity(UUID id, UserName userName, FullName fullName, Email email, Password password) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public UserEntity(UUID id, UserName userName, FullName fullName, Email email, Password password, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
        this.id = id;
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
}
