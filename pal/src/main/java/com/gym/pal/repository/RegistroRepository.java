package com.gym.pal.repository;

import com.gym.pal.model.Registro;

import java.util.ArrayList;
import java.util.List;

public class RegistroRepository {
    private List<Registro> registros = new ArrayList<>();

    public List<Registro> getAllSocio() {
        return registros;
    }

    public Registro createUser(Registro registro) {
        registros.add(registro);
        return registro;
    }
}
