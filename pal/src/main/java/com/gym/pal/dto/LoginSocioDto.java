package com.gym.pal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginSocioDto {
    @JsonProperty("pass")
    private String pass;
    @JsonProperty("email")
    private String email;
}
