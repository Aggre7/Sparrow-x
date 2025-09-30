package com.sparrowx.profile.data.postgres.repositories;

import com.sparrowx.profile.data.postgres.entities.ProfileEntity;

import com.sparrowx.profile.valueobjects.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;



@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {
    Optional<ProfileEntity> findByUsername_Value(String username);
    Optional<ProfileEntity> findByEmail_Value(String email);
    Optional<ProfileEntity> findByUserNameAndIsDeletedFalse(UserName username);
    Optional<ProfileEntity> findByIdAndIsDeletedFalse(UUID id);
}