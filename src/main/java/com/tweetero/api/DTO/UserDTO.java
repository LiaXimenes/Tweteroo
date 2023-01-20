package com.tweetero.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
    @NotBlank String userName,
    @NotBlank String avatar
    ) {
    
}
