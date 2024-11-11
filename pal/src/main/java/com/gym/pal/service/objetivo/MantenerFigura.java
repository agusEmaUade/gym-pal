package com.gym.pal.service.objetivo;

import com.gym.pal.model.*;
import com.gym.pal.service.objetivo.Objetivo;

import java.math.BigDecimal;
import java.util.List;

public class MantenerFigura extends Objetivo {

    @Override
    public String getType() {
        return "mantenerFigura";
    }

    @Override
    public void crearRutina(List<Entrenamiento> entrenamientos){
        Rutina bajarDePesoRutina = new Rutina();
        bajarDePesoRutina.setEntrenamientos(entrenamientos);
        this.setRutina(bajarDePesoRutina);
    }

    @Override
    public boolean cumpleObjetivo(Socio socio) {
        BigDecimal pesoInicial = socio.getMediciones().stream()
                .findFirst()
                .map(medicion -> medicion.getPeso())
                .orElse(BigDecimal.ZERO);


        if (pesoInicial.equals(BigDecimal.ZERO)) {
            return false;
        }


        BigDecimal rangoTolerancia = BigDecimal.valueOf(5); // N es configurable, por ejemplo, +-5kg

        BigDecimal pesoActual = socio.getMediciones().stream()
                .reduce((first, second) -> second)
                .map(medicion -> medicion.getPeso())
                .orElse(BigDecimal.ZERO);


        BigDecimal diferencia = pesoActual.subtract(pesoInicial).abs();
        return true;
    }



}
