package com.elm.hackathon.repository;

import java.util.Optional;

import com.elm.hackathon.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  User findByEmail(String email);

  Optional<User> findByFirebaseId(String firebaseId);
}
