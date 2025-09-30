package com.sparrowx.profile.data.neo4j.nodes;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@RelationshipProperties
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowRelation {

    @Id
    private UUID id; // can be generated as UUID.randomUUID()

    @TargetNode
    private ProfileNode followee;
}
