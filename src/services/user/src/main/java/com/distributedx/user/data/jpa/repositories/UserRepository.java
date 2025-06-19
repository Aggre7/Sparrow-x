package com.distributedx.user.data.jpa.repositories;

import com.distributedx.user.data.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    //PassengerEntity findPassengerByPassportNumberAndIsDeletedFalse(PassportNumber passportNumber);
}
