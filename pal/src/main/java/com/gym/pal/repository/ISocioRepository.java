package com.gym.pal.repository;

import com.gym.pal.model.Medicion;
import com.gym.pal.model.Socio;
import com.gym.pal.service.objetivo.Objetivo;

import java.util.List;
import java.util.Optional;

public interface ISocioRepository {
    List<Socio> getAllSocio();

    Socio crear(Socio socio);

    Optional<Socio> findByEmailAndPass(String email, String pass);

    Optional<Socio> findById(String id);

    void actualizarMediciones(String socioId, Medicion nuevaMedicion);

    void setearObjetivo(String socioId, Objetivo objetivo);

    void actualizarTrofeos(String socioId, String trofeo);
}
