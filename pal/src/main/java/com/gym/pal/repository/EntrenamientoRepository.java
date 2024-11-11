package com.gym.pal.repository;

import com.gym.pal.model.Ejercicio;
import com.gym.pal.model.Entrenamiento;
import com.gym.pal.model.Musculo;
import com.gym.pal.repository.EjercicioRepository;

import java.util.ArrayList;
import java.util.List;

public class EntrenamientoRepository {

    private List<Entrenamiento> entrenamientosBajarDePeso = new ArrayList<>();
    private List<Entrenamiento> entrenamientosTonificarCuerpo = new ArrayList<>();
    private List<Entrenamiento> entrenamientossMantenerFigura = new ArrayList<>();

    public EntrenamientoRepository() {
        intEntrenamientos();
    }

    public List<Entrenamiento> getentrenamientosBajarDePeso() {
        return entrenamientosBajarDePeso;
    }

    public List<Entrenamiento> getentrenamientosTonificarCuerpo() {
        return entrenamientosTonificarCuerpo;
    }

    public List<Entrenamiento> getentrenamientossMantenerFigura() {
        return entrenamientossMantenerFigura;
    }

    private void intEntrenamientos() {
        // Obtener las listas de ejercicios desde EjercicioRepository
        List<Ejercicio> ejerciciosBajarDePeso =EjercicioRepository.getEjerciciosBajarDePeso();
        List<Ejercicio> ejerciciosTonificarCuerpo = EjercicioRepository.getEjerciciosTonificarCuerpo();
        List<Ejercicio> ejerciciosMantenerFigura = EjercicioRepository.getEjerciciosMantenerFigura();

        // Crear entrenamientos para cada categoría
        Entrenamiento entrenamientoBajarDePeso = new Entrenamiento(ejerciciosBajarDePeso, 1, Musculo.PIERNAS, "RegistroBajarDePeso", 1);
        Entrenamiento entrenamientoTonificarCuerpo = new Entrenamiento(ejerciciosTonificarCuerpo, 2, Musculo.ESPALDA, "RegistroTonificarCuerpo", 2);
        Entrenamiento entrenamientoMantenerFigura = new Entrenamiento(ejerciciosMantenerFigura, 3, Musculo.ESPALDA, "RegistroMantenerFigura", 3);

        // Agregar los entrenamientos a las respectivas listas
        entrenamientosBajarDePeso.add(entrenamientoBajarDePeso);
        entrenamientosTonificarCuerpo.add(entrenamientoTonificarCuerpo);
        entrenamientossMantenerFigura.add(entrenamientoMantenerFigura);
    }
}
