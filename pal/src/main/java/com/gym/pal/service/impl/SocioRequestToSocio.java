package com.gym.pal.service.impl;

import com.gym.pal.controller.dto.CreateSocioDto;
import com.gym.pal.model.Socio;

import java.math.BigDecimal;
import java.util.function.Function;

public class SocioRequestToSocio implements Function<CreateSocioDto, Socio> {

    @Override
    public Socio apply(CreateSocioDto request) {
        return Socio.builder().altura(BigDecimal.ONE).build();

    }
}
