package com.sparrowx.profile.data.cassandra.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("follows")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowTable {

    // Partition key → groups by follower for fast "who do I follow?" queries
    @PrimaryKeyColumn(name = "follower_id", type = PrimaryKeyType.PARTITIONED)
    private UUID followerId;

    // Clustering key → enables range queries & uniqueness
    @PrimaryKeyColumn(name = "followee_id", type = PrimaryKeyType.CLUSTERED)
    private UUID followeeId;
}

