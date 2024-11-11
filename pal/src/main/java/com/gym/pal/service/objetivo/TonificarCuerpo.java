package com.gym.pal.service.objetivo;

import com.gym.pal.model.Entrenamiento;
import com.gym.pal.model.Rutina;
import com.gym.pal.service.objetivo.Objetivo;

import java.util.List;

public class TonificarCuerpo extends Objetivo {
    @Override
    public void crearRutina(List<Entrenamiento> entrenamientos){
        Rutina bajarDePesoRutina = new Rutina();
        bajarDePesoRutina.setEntrenamientos(entrenamientos);
        this.setRutina(bajarDePesoRutina);
    }

    @Override
    public void cumpleObjetivo(){

    }
}
