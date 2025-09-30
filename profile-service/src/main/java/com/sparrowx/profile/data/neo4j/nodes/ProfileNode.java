package com.sparrowx.profile.data.neo4j.nodes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node("Profile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProfileNode {

    @Id
    private UUID id;

    @Property("username")
    private String username;

    @Property("email")
    private String email;

    private LocalDate joinDate;

    private String bio;
    private String location;
    private String website;
    private LocalDate birthDate;

    private String avatarUrl;
    private String bannerUrl;

    // Relationships
    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private Set<ProfileNode> followees = new HashSet<>();

    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.INCOMING)
    private Set<ProfileNode> followers = new HashSet<>();
}
