package com.gym.pal.repository;

import com.gym.pal.model.Ejercicio;
import com.gym.pal.model.Entrenamiento;
import com.gym.pal.model.Musculo;
import com.gym.pal.repository.EjercicioRepository;

import java.util.ArrayList;
import java.util.List;

public class EntrenamientoRepository {
    private List<Entrenamiento> entrenamientos = intEntrenamientos();

    public Entrenamiento createUser(Entrenamiento entrenamiento) {
        entrenamientos.add(entrenamiento);
        return entrenamiento;
    }
    private List<Entrenamiento> intEntrenamientos() {

        //Entrenamiento bajardepeso = new Entrenamiento(initEjercicioBajardePeso, 1, Musculo.BRAZOS, "Registro1", 1);
        //return List.of(bajardepeso);
        return null;
    }
}
