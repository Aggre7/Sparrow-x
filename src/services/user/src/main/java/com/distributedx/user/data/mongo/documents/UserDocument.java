package com.distributedx.user.data.mongo.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDocument {
    @Id
    private ObjectId id;
    private UUID userId;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private boolean isDeleted;

    public UserDocument(UUID userId, String userName, String fullName, String email, String password, boolean isDeleted) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.isDeleted = isDeleted;
    }
}

