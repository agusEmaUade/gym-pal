package com.gym.pal.repository;

import com.gym.pal.model.Ejercicio;
import com.gym.pal.model.Nivel;

import java.util.List;

public class EjercicioRepository {
    private List<Ejercicio> ejercicios = initEjercicio();

    public List<Ejercicio> getAllSocio() {
        return ejercicios;
    }

    public Ejercicio createUser(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
        return ejercicio;
    }
    private List<Ejercicio> initEjercicioBajardePeso() {

        Ejercicio sentadilla = new Ejercicio("Sentadilla", 12, 4, 60, "Piernas", Nivel.BAJO), 2;
        Ejercicio plancha = new Ejercicio("Plancha", 30, 3, 0, "Core", Nivel.BAJO, 2 );  // Ejercicio de tiempo en segundos
        Ejercicio saltoConCuerda = new Ejercicio("Salto con Cuerda", 60, 3, 0, "Cardio", Nivel.BAJO, 2);  // Duración en segundos
        return List.of(sentadilla, plancha, saltoConCuerda);

    }
    private List<Ejercicio> initEjercicioTonificarCuerpo() {
       Ejercicio curlDeBiceps = new Ejercicio("Curl de Bíceps", 15, 4, 20, "Bíceps", Nivel.MEDIO,5);
        Ejercicio saltoconpesa = new Ejercicio("Salto con pesa", 10, 4, 40, "Piernas", Nivel.MEDIO,5 );
        Ejercicio remoConMancuerna = new Ejercicio("Remo con Mancuerna", 12, 4, 30, "Espalda", Nivel.MEDIO,5;
        return List.of(curlDeBiceps, saltoconpesa, remoConMancuerna);

    }
    private List<Ejercicio> initEjercicioMantenerLaFigura() {
        Ejercicio pressDeBanca = new Ejercicio("Press de Banca", 10, 3, 80, "Pectorales", Nivel.ALTO,3);
        Ejercicio pesoMuerto = new Ejercicio("Peso Muerto", 8, 4, 100, "Espalda Baja", Nivel.ALTO,3);
        Ejercicio pressMilitar = new Ejercicio("Press Militar", 10, 3, 50, "Hombros", Nivel.ALTO,3);


        return List.of(pressDeBanca, pesoMuerto, pressMilitar);

    }



}
