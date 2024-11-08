package com.gym.pal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
public class Socio {
    private int edad;
    private Sexo sexo;
    private BigDecimal peso;
    private BigDecimal altura;
    private int nivelAerobico;
    private List<Medicion> mediciones;
    private String nombre;
    private String pass;
    private String email;
    private Rutina rutina;
    private List<Trofeo> trofeos;
}
