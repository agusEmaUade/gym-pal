package com.gym.pal.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MedicionDto {
    @JsonProperty("masa_muscular")
    private BigDecimal masaMuscular;
    @JsonProperty("porcentaje_grasa_corporal")
    private BigDecimal porcentajeGrasaCorporal;
    @JsonProperty("peso")
    private BigDecimal peso;
    @JsonProperty("email")
    private String email;
}
