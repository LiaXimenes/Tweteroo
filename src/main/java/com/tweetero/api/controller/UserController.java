package com.tweetero.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.DTO.UserDTO;
import com.tweetero.api.model.User;
import com.tweetero.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sign-up")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO req){
        List<User> userExists = service.findUserByName(req.userName());
        
        if(userExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        service.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ok");
    }
    
}
