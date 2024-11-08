package com.gym.pal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Medicion {
    private BigDecimal masaMuscular;
    private BigDecimal porcentajeGrasaCorporal;
    private BigDecimal peso;
}
