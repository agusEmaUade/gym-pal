package com.gym.pal.service.impl;

import com.gym.pal.dto.MedicionDto;
import com.gym.pal.model.Medicion;

import java.util.function.Function;

public class MedicionDtoToMedicion implements Function<MedicionDto, Medicion> {
    @Override
    public Medicion apply(MedicionDto request) {
        return Medicion.builder()
                .masaMuscular(request.getMasaMuscular())
                .peso(request.getPeso())
                .porcentajeGrasaCorporal(request.getPorcentajeGrasaCorporal())
                .build();
    }
}
