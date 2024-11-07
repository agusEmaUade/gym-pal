package com.gym.pal.repository;

import com.gym.pal.model.Medicion;

import java.util.ArrayList;
import java.util.List;

public class MedicionRepository {
    private List<Medicion> mediciones = new ArrayList<>();

    public List<Medicion> getAllSocio() {
        return mediciones;
    }

    public Medicion createUser(Medicion medicion) {
        mediciones.add(medicion);
        return medicion;
    }
}
