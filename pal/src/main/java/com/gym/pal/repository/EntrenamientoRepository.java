package com.gym.pal.repository;

import com.gym.pal.model.Entrenamiento;

import java.util.ArrayList;
import java.util.List;

public class EntrenamientoRepository {
    private List<Entrenamiento> entrenamientos = new ArrayList<>();

    public List<Entrenamiento> getAllSocio() {
        return entrenamientos;
    }

    public Entrenamiento createUser(Entrenamiento entrenamiento) {
        entrenamientos.add(entrenamiento);
        return entrenamiento;
    }
}
