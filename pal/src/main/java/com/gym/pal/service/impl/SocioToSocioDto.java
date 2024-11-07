package com.gym.pal.service.impl;

import com.gym.pal.model.Socio;
import com.gym.pal.controller.dto.SocioDto;

import java.util.function.Function;

public class SocioToSocioDto implements Function<Socio, SocioDto> {
    @Override
    public SocioDto apply(Socio socio){
     return SocioDto.builder().name(socio.getNombre()).build();
    }
}
