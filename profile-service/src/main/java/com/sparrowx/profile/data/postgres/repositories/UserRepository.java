package com.sparrowx.profile.data.postgres.repositories;

import com.sparrowx.profile.data.postgres.entities.UserEntity;
import com.sparrowx.profile.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findUserByEmailAndIsDeletedFalse(Email email);
}
