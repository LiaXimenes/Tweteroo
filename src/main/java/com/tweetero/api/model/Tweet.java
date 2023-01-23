package com.tweetero.api.model;

import com.tweetero.api.DTO.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO req, String avatar) {
        this.userName = req.userName();
        this.text = req.text();
        this.avatar = avatar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 140, nullable = false)
    private String text;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column
    private String avatar;
    
}
