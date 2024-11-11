package com.gym.pal.service;

import com.gym.pal.dto.LoginSocioDto;
import com.gym.pal.dto.CreateSocioDto;
import com.gym.pal.dto.MedicionDto;
import com.gym.pal.dto.SocioDto;

public interface SocioService {
    SocioDto crear(CreateSocioDto request);

    SocioDto login(LoginSocioDto request);

    String registroPeso(String socioId, MedicionDto dto);

    String registrarObjetivo(String socioId, String tipoObjetivo);
}
