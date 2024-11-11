package com.gym.pal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Entrenamiento {

    private List<Ejercicio> ejercicios;
    private int dias;
    private Musculo musculo;
    private String registros;
    private int horas;

}
