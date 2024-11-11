package com.gym.pal.repository;

import com.gym.pal.model.Ejercicio;
import java.util.ArrayList;
import java.util.List;

public class EjercicioRepository {

    private List<Ejercicio> ejerciciosBajarDePeso = new ArrayList<>();
    private List<Ejercicio> ejerciciosTonificarCuerpo = new ArrayList<>();
    private List<Ejercicio> ejerciciosMantenerFigura = new ArrayList<>();

    public EjercicioRepository() {
        initEjercicios();
    }

    public static List<Ejercicio> getEjerciciosBajarDePeso() {
        return ejerciciosBajarDePeso;
    }

    public static List<Ejercicio> getEjerciciosTonificarCuerpo() {
        return ejerciciosTonificarCuerpo;
    }

    public static List<Ejercicio> getEjerciciosMantenerFigura() {
        return ejerciciosMantenerFigura;
    }

    public Ejercicio addEjercicio(Ejercicio ejercicio) {
        clasificarEjercicio(ejercicio);
        return ejercicio;
    }

    private void initEjercicios() {
        Ejercicio sentadilla = new Ejercicio("Sentadilla", 12, 4, 60, "Piernas", 2);
        Ejercicio plancha = new Ejercicio("Plancha", 30, 3, 0, "Core", 1);
        Ejercicio saltoConCuerda = new Ejercicio("Salto con Cuerda", 60, 3, 0, "Cardio", 3);
        Ejercicio curlDeBiceps = new Ejercicio("Curl de Bíceps", 15, 4, 20, "Bíceps", 2);
        Ejercicio saltoConPesa = new Ejercicio("Salto con pesa", 10, 4, 40, "Piernas", 4);
        Ejercicio remoConMancuerna = new Ejercicio("Remo con Mancuerna", 12, 4, 30, "Espalda", 3);
        Ejercicio pressDeBanca = new Ejercicio("Press de Banca", 10, 3, 80, "Pectorales", 5);
        Ejercicio pesoMuerto = new Ejercicio("Peso Muerto", 8, 4, 100, "Espalda Baja", 4);
        Ejercicio pressMilitar = new Ejercicio("Press Militar", 10, 3, 50, "Hombros", 5);

        clasificarEjercicio(sentadilla);
        clasificarEjercicio(plancha);
        clasificarEjercicio(saltoConCuerda);
        clasificarEjercicio(curlDeBiceps);
        clasificarEjercicio(saltoConPesa);
        clasificarEjercicio(remoConMancuerna);
        clasificarEjercicio(pressDeBanca);
        clasificarEjercicio(pesoMuerto);
        clasificarEjercicio(pressMilitar);
    }

    private void clasificarEjercicio(Ejercicio ejercicio) {
        int nivelAerobico = ejercicio.getNivelAerobico();

        if (nivelAerobico >= 3) {
            ejerciciosBajarDePeso.add(ejercicio);
        }
        if (nivelAerobico <= 4) {
            ejerciciosTonificarCuerpo.add(ejercicio);
        }
        if (nivelAerobico >= 2 && nivelAerobico <= 4) {
            ejerciciosMantenerFigura.add(ejercicio);
        }
    }
}
