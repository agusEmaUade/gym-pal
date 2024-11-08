package com.gym.pal.repository;

import com.gym.pal.model.Medicion;
import com.gym.pal.model.Socio;

import java.util.List;
import java.util.Optional;

public interface ISocioRepository {
    List<Socio> getAllSocio();

    Socio crear(Socio socio);

    Optional<Socio> findByEmailAndPass(String email, String pass);
    Optional<Socio> findByEmail(String email);

    void actualizarMediciones(String email, Medicion nuevaMedicion);
}
