package com.gym.pal.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginRequest {
    @JsonProperty("pass")
    private String pass;
    @JsonProperty("email")
    private String email;
}
