package com.gym.pal.service.impl;

import com.gym.pal.dto.SocioDto;
import com.gym.pal.dto.TipoDeTrofeoDto;
import com.gym.pal.model.Socio;
import com.gym.pal.model.TipoDeTrofeo;
import com.gym.pal.model.Trofeo;

import java.util.UUID;
import java.util.function.Function;

public class TrofeoDtoToTrofeo implements Function<TipoDeTrofeoDto, Trofeo> {

    @Override
    public Trofeo apply(TipoDeTrofeoDto tipoDeTrofeoDto) {
        return Trofeo.builder()
                .id(UUID.randomUUID().toString())
                .tipoDeTrofeo(TipoDeTrofeo.valueOf(tipoDeTrofeoDto.name()))
                .build();
    }
}
