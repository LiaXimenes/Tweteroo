package com.tweetero.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    
}
