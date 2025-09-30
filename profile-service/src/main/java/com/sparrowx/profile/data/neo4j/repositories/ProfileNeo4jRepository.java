package com.sparrowx.profile.data.neo4j.repositories;


import com.sparrowx.profile.data.neo4j.nodes.ProfileNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileNeo4jRepository extends Neo4jRepository<ProfileNode, UUID> {

    Optional<ProfileNode> findByUsername(String username);

    @Query("MATCH (p:Profile)-[:FOLLOWS]->(f:Profile) WHERE p.id = $id RETURN f")
    List<ProfileNode> findFollowees(UUID id);

    @Query("MATCH (p:Profile)<-[:FOLLOWS]-(f:Profile) WHERE p.id = $id RETURN f")
    List<ProfileNode> findFollowers(UUID id);

    @Query("MATCH (a:Profile {id:$followerId}), (b:Profile {id:$followeeId}) RETURN exists( (a)-[:FOLLOWS]->(b) )")
    boolean existsFollowRelationship(UUID followerId, UUID followeeId);
}
