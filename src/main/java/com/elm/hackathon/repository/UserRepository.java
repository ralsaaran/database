package com.elm.hackathon.repository;

import java.util.Optional;

import com.elm.hackathon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

  Optional<User> findByFirebaseId(String firebaseId);
}
