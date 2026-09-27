package com.daniel.backend.repository;

import com.daniel.backend.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository
        extends MongoRepository<User, String> {

}