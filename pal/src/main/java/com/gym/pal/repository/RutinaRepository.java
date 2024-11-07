package com.gym.pal.repository;

import com.gym.pal.model.Rutina;

import java.util.ArrayList;
import java.util.List;

public class RutinaRepository {
    private List<Rutina> rutinas = new ArrayList<>();

    public List<Rutina> getAllSocio() {
        return rutinas;
    }

    public Rutina createUser(Rutina rutina) {
        rutinas.add(rutina);
        return rutina;
    }

}
