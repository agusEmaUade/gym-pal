package com.gym.pal.service.impl;

import com.gym.pal.model.Socio;
import com.gym.pal.dto.SocioDto;

import java.util.function.Function;

public class SocioToSocioDto implements Function<Socio, SocioDto> {
    @Override
    public SocioDto apply(Socio socio) {
        return SocioDto.builder()
                .id(socio.getId())
                .name(socio.getNombre())
                .email(socio.getEmail())
                .build();
    }
}
