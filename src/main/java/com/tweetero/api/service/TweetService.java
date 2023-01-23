package com.tweetero.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

    public Page<Tweet> getTweets(int pageNumber, int size){
        Pageable pageable = PageRequest.of(pageNumber, size);
        return repository.findAll(pageable);
    }
    
    public List<Tweet> getTweetsByUser(String userName){
        return repository.findByUsername(userName);
    }
    
}
