package com.gym.pal.service.impl;

import com.gym.pal.controller.dto.SocioRequest;
import com.gym.pal.domain.Socio;
import com.gym.pal.domain.dto.SocioDto;

import java.util.function.Function;

public class SocioToSocioDto implements Function<Socio, SocioDto> {
    @Override
    public SocioDto apply(Socio socio){
     SocioDto dto = new SocioDto();
     return dto;
    }
}
