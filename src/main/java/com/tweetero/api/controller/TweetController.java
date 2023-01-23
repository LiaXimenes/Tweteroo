package com.tweetero.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.DTO.TweetDTO;
import com.tweetero.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    TweetService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid TweetDTO req){
        service.createTweet(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ok");
    }

    
}
