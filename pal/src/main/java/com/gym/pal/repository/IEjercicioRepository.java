package com.gym.pal.repository;

import com.gym.pal.model.Ejercicio;

import java.util.List;

public interface IEjercicioRepository {
    Ejercicio crear(Ejercicio ejercicio);
    List<Ejercicio> getEjerciciosBajarDePeso();
    List<Ejercicio> getEjerciciosTonificarCuerpo();
    List<Ejercicio> getEjerciciosMantenerFigura();

}
