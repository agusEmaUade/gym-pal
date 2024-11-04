package com.gym.pal.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gym.pal.domain.*;

import java.math.BigDecimal;

public class SocioRequest {
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
}
