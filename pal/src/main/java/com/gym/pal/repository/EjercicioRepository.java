package com.gym.pal.repository;

import com.gym.pal.domain.Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRepository {
    private List<Ejercicio> ejercicios = new ArrayList<>();

    public List<Ejercicio> getAllSocio() {
        return ejercicios;
    }

    public Ejercicio createUser(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
        return ejercicio;
    }
}
