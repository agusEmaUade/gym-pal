package com.gym.pal.service;

import com.gym.pal.controller.dto.LoginSocioDto;
import com.gym.pal.controller.dto.CreateSocioDto;
import com.gym.pal.controller.dto.MedicionDto;
import com.gym.pal.controller.dto.SocioDto;

public interface SocioService {
    SocioDto crear(CreateSocioDto request);

    SocioDto login(LoginSocioDto request);

    String registroPeso(String socioId, MedicionDto dto);

    String registrarObjetivo(String socioId, String tipoObjetivo);
}
