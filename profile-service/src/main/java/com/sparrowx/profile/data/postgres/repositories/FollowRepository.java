package com.sparrowx.profile.data.postgres.repositories;

import com.sparrowx.profile.data.postgres.entities.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, UUID> {
    List<FollowEntity> findByFollowerId(UUID followerId);
    List<FollowEntity> findByFolloweeId(UUID followeeId);
    Optional<FollowEntity> findByFollowerIdAndFolloweeId(UUID followerId, UUID followeeId);
}