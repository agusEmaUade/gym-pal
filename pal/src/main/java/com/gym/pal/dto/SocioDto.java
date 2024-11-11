package com.gym.pal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SocioDto {
    private String id;
    private String name;
    private String email;
}
