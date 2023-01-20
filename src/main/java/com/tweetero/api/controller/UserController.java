package com.tweetero.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.DTO.UserDTO;
import com.tweetero.api.model.User;
import com.tweetero.api.repository.UserRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/sign-up")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public String createUser(@RequestBody @Valid UserDTO req){
        repository.save(new User(req));
        return "ok";
    }
    
}
