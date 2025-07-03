package com.distributedx.user.data.mongo.repositories;

import com.distributedx.user.data.mongo.documents.UserDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserReadRepository extends MongoRepository<UserDocument, ObjectId> {
    UserDocument findUserByUserIdAndIsDeletedFalse(UUID userId);
}

