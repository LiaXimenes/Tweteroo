package com.tweetero.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tweetero.api.DTO.TweetDTO;
import com.tweetero.api.model.Tweet;
import com.tweetero.api.model.User;
import com.tweetero.api.repository.TweetRepository;
import com.tweetero.api.repository.UserRepository;

public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void createTweet(TweetDTO data){

        List<User> user = userRepository.findByUsername(data.userName());

        repository.save(new Tweet(data, user.get(0).getAvatar()));
    }
    
}
