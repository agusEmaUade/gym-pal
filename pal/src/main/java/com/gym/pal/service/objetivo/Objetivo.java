package com.gym.pal.service.objetivo;

import com.gym.pal.model.Entrenamiento;
import com.gym.pal.model.Rutina;
import com.gym.pal.model.Socio;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class  Objetivo {
    private Rutina rutina;


    abstract  void crearRutina(List<Entrenamiento> entrenamientos);

    abstract boolean cumpleObjetivo(Socio socio);
}
