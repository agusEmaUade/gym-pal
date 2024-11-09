package com.gym.pal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Ejercicio {
    private String nombre;
    private int repeticiones;
    private int series;
    private int peso_asignado;
    private String exigencia_muscular;
    // private file video;
    private Nivel nivel;
    private int nivelAerobico;







}
