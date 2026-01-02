package com.restoapp.backend.repository;

import com.restoapp.backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
