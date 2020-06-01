package com.github.richygreat.aaum.user.repository;

import com.github.richygreat.aaum.user.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
}
