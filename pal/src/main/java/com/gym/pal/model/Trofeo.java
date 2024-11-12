package com.gym.pal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Trofeo {
    private String id;
    private TipoDeTrofeo tipoDeTrofeo;
}
