package com.gym.pal.service;

import com.gym.pal.controller.dto.EjercicioDto;

public interface RutinaService {
    void registrar(EjercicioDto ejercicio, String socioId);
}
