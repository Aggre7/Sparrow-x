package com.sparrowx.profile.data.cassandra.repositories;


import com.sparrowx.profile.data.cassandra.tables.FollowTable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowCassandraRepository extends CassandraRepository<FollowTable, UUID> {

    // Get all users someone follows
    List<FollowTable> findByFollowerId(UUID followerId);

    // Get all followers of a user
    List<FollowTable> findByFolloweeId(UUID followeeId);
}

