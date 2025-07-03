package com.distributedx.user.data.jpa.repositories;

import com.distributedx.user.data.jpa.entities.UserEntity;
import com.distributedx.user.users.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findUserByEmailAndIsDeletedFalse(Email email);
}
