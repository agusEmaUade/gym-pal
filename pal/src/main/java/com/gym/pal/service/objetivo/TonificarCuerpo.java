package com.gym.pal.service.objetivo;

import com.gym.pal.model.Entrenamiento;
import com.gym.pal.model.Rutina;
import com.gym.pal.model.Sexo;
import com.gym.pal.model.Socio;

import java.math.BigDecimal;
import java.util.List;

public class TonificarCuerpo extends Objetivo {

    @Override
    public String getType() {
        return "tonificarCuerpo";
    }

    @Override
    public void crearRutina(List<Entrenamiento> entrenamientos){
        Rutina bajarDePesoRutina = new Rutina();
        bajarDePesoRutina.setEntrenamientos(entrenamientos);
        this.setRutina(bajarDePesoRutina);
    }

    @Override
    public boolean cumpleObjetivo(Socio socio) {
        return getCalculoPorcentajeMasa(socio.getSexo(), socio.getPeso(), socio.getAltura());
    }

    private boolean getCalculoPorcentajeMasa(Sexo sexo, BigDecimal peso, BigDecimal altura){
        return true;
    }
}
