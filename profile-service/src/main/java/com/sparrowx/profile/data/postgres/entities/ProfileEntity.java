package com.sparrowx.profile.data.postgres.entities;

import buildingblocks.core.model.BaseEntity;
import com.sparrowx.profile.valueobjects.Email;
import com.sparrowx.profile.valueobjects.UserName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProfileEntity extends BaseEntity<UUID> {

    @Embedded
    private Email email;

    @Embedded
    private UserName username;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    @Column(length = 280)
    private String bio;

    private String location;

    private String website;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String avatarUrl;
    
    public ProfileEntity(UUID id, Email email, UserName username, LocalDate joinDate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.joinDate = joinDate;
    }

    public ProfileEntity(UUID id,
                         Email email,
                         UserName username,
                         LocalDate joinDate,
                         String bio,
                         String location,
                         String website,
                         LocalDate birthDate,
                         String avatarUrl,
                         java.time.LocalDateTime createdAt,
                         Long createdBy,
                         java.time.LocalDateTime lastModified,
                         Long lastModifiedBy,
                         Long version,
                         boolean isDeleted) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.joinDate = joinDate;
        this.bio = bio;
        this.location = location;
        this.website = website;
        this.birthDate = birthDate;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.version = version;
        this.isDeleted = isDeleted;
    }
}
