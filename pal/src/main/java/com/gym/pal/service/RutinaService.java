package com.gym.pal.service;

import com.gym.pal.dto.EjercicioDto;

public interface RutinaService {
    void registrar(EjercicioDto ejercicio, String socioId);
}
