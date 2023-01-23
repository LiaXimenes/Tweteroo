package com.tweetero.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
        @NotBlank String text,
        @NotBlank String userName
        ) {
}