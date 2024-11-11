package com.gym.pal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gym.pal.model.*;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class CreateSocioDto {
    @JsonProperty("sexo")
    private Sexo sexo;
    @JsonProperty("peso")
    private BigDecimal peso;
    @JsonProperty("altura")
    private BigDecimal altura;
    @JsonProperty("nivelAerobico")
    private int nivelAerobico;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("pass")
    private String pass;
    @JsonProperty("email")
    private String email;
    @JsonProperty("edad")
    private int edad;
}
