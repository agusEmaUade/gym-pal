package com.gym.pal.service.impl;

import com.gym.pal.controller.dto.CreateSocioDto;
import com.gym.pal.model.Socio;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Function;

public class SocioRequestToSocio implements Function<CreateSocioDto, Socio> {

    @Override
    public Socio apply(CreateSocioDto request) {
        return Socio.builder()
                .id(UUID.randomUUID().toString())
                .email(request.getEmail())
                .nombre(request.getNombre())
                .pass(request.getPass())
                .peso(request.getPeso())
                .altura(request.getAltura())
                .edad(request.getEdad())
                .nivelAerobico(request.getNivelAerobico())
                .sexo(request.getSexo())
                .build();
    }
}
