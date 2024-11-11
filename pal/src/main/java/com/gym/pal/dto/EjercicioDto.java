package com.gym.pal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class EjercicioDto {
    @JsonProperty("cant_repeticiones")
    private int cantRepeticiones;
    @JsonProperty("cant_peso")
    private BigDecimal cantPeso;
    @JsonProperty("cant_horas")
    private int cantHoras;
}
