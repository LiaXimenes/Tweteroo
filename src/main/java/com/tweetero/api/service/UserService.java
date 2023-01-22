package com.tweetero.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tweetero.api.DTO.UserDTO;
import com.tweetero.api.model.User;
import com.tweetero.api.repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository repository;

    public void createUser(UserDTO data){
        repository.save(new User(data));
    }

    public List<User> findUserByName(String username) {
        return repository.findByUsername(username); 
    }
    
}
