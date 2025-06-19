package com.distributedx.user.data.jpa.entities;

import buildingblocks.core.model.BaseEntity;
import com.distributedx.user.users.valueobjects.Email;
import com.distributedx.user.users.valueobjects.FullName;
import com.distributedx.user.users.valueobjects.Password;
import com.distributedx.user.users.valueobjects.UserName;
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
    private Email email;
    @Embedded
    private Password password;
    @Embedded
    @Column(name = "fullname")
    private FullName fullName;



    public UserEntity(UUID id, UserName userName, Email email, Password password, FullName fullName) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public UserEntity(UUID id, UserName userName, Email email, Password password, FullName fullName, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.version = version;
        this.isDeleted = isDeleted;
    }
}
