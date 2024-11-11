package com.gym.pal.service.objetivo;

import com.gym.pal.model.Entrenamiento;
import com.gym.pal.model.Musculo;
import com.gym.pal.model.Rutina;
import com.gym.pal.model.Sexo;
import com.gym.pal.service.objetivo.Objetivo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class BajarDePeso extends Objetivo {

    @Override
    public void crearRutina(List<Entrenamiento> entrenamientos){
        Rutina bajarDePesoRutina = new Rutina();
        bajarDePesoRutina.setEntrenamientos(entrenamientos);
        this.setRutina(bajarDePesoRutina);
    }

    @Override
    public BigDecimal cumpleObjetivo(Sexo sexo, BigDecimal peso, BigDecimal altura) {
        BigDecimal pesoIdeal = BigDecimal.ZERO;

        altura = altura.multiply(BigDecimal.valueOf(100));

        if (Sexo.MASCULINO.equals(sexo)) {
            pesoIdeal = altura.subtract(BigDecimal.valueOf(100))
                    .subtract(altura.subtract(BigDecimal.valueOf(150))
                            .divide(BigDecimal.valueOf(4), RoundingMode.HALF_UP));
        } else if (Sexo.FEMENINO.equals(sexo)) {
            pesoIdeal = altura.subtract(BigDecimal.valueOf(100))
                    .subtract(altura.subtract(BigDecimal.valueOf(150))
                            .divide(BigDecimal.valueOf(2.5), RoundingMode.HALF_UP));
        } else {
            throw new IllegalArgumentException("Sexo no válido. Use 'MASCULINO' o 'FEMENINO'.");
        }

        return pesoIdeal.setScale(2, RoundingMode.HALF_UP);
    }
}
