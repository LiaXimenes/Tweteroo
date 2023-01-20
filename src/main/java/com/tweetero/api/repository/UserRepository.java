package com.tweetero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
