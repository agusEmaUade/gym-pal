package com.gym.pal.service.impl;

import com.gym.pal.controller.dto.SocioRequest;
import com.gym.pal.model.Socio;

import java.math.BigDecimal;
import java.util.function.Function;

public class SocioRequestToSocio implements Function<SocioRequest, Socio> {

    @Override
    public Socio apply(SocioRequest request) {
        return Socio.builder().altura(BigDecimal.ONE).build();

    }
}
