package com.gym.pal.repository;

import com.gym.pal.domain.Ejercicio;
import com.gym.pal.domain.Nivel;

import java.util.ArrayList;
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
    private List<Ejercicio> initEjercicio(){
        Ejercicio sentadilla = new Ejercicio("Sentadilla", 12, 4, 60, "Piernas", Nivel.BAJO);

        Ejercicio pressDeBanca = new Ejercicio("Press de Banca", 10, 3, 80, "Pectorales", Nivel.ALTO);

        Ejercicio curlDeBiceps = new Ejercicio("Curl de Bíceps", 15, 4, 20, "Bíceps", Nivel.MEDIO);

        return List.of(sentadilla, pressDeBanca, curlDeBiceps);
    }
}
