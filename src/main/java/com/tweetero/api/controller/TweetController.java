package com.tweetero.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.DTO.TweetDTO;
import com.tweetero.api.model.Tweet;
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

    @GetMapping
    public Page<Tweet> getTweets(@RequestParam(value = "page", defaultValue = "0") int page){
        return service.getTweets(page, 5);
    }
    
}
