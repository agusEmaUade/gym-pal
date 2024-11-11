package com.gym.pal.repository;

import com.gym.pal.model.Ejercicio;
import com.gym.pal.model.Nivel;
import com.gym.pal.model.Socio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EjercicioRepository implements IEjercicioRepository {

    private List<Ejercicio> ejercicios = initEjercicios();
    public Ejercicio crear(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);

        return ejercicio;
    }


    public List<Ejercicio> getEjerciciosBajarDePeso() {
        return ejercicios.stream().filter(e -> e.getNivelAerobico() >= 3).toList();
    }

    public List<Ejercicio> getEjerciciosTonificarCuerpo() {
        return ejercicios.stream().filter(e -> e.getNivelAerobico() <= 4).toList();
    }

    public List<Ejercicio> getEjerciciosMantenerFigura() {
        return ejercicios.stream().filter(e -> e.getNivelAerobico()  >= 2 && e.getNivelAerobico() <= 4).toList();
    }

    private List<Ejercicio> initEjercicios() {
        Ejercicio sentadilla = new Ejercicio("Sentadilla", 12, 4, 60, "Piernas", Nivel.MEDIO,2);
        Ejercicio plancha = new Ejercicio("Plancha", 30, 3, 0, "Core", Nivel.BAJO,1);
        Ejercicio saltoConCuerda = new Ejercicio("Salto con Cuerda", 60, 3, 0, "Cardio",Nivel.MEDIO, 3);
        Ejercicio curlDeBiceps = new Ejercicio("Curl de Bíceps", 15, 4, 20, "Bíceps", Nivel.MEDIO,2);
        Ejercicio saltoConPesa = new Ejercicio("Salto con pesa", 10, 4, 40, "Piernas", Nivel.ALTO,4);
        Ejercicio remoConMancuerna = new Ejercicio("Remo con Mancuerna", 12, 4, 30, "Espalda",Nivel.MEDIO, 3);
        Ejercicio pressDeBanca = new Ejercicio("Press de Banca", 10, 3, 80, "Pectorales", Nivel.ALTO,5);
        Ejercicio pesoMuerto = new Ejercicio("Peso Muerto", 8, 4, 100, "Espalda Baja", Nivel.ALTO,4);
        Ejercicio pressMilitar = new Ejercicio("Press Militar", 10, 3, 50, "Hombros", Nivel.ALTO,5);

        return List.of(sentadilla, plancha, saltoConCuerda, saltoConPesa, curlDeBiceps, remoConMancuerna, pressDeBanca, pesoMuerto, pressMilitar);
    }
}
