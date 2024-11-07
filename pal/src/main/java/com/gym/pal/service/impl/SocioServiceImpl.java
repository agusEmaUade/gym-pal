package com.gym.pal.service.impl;

import com.gym.pal.controller.dto.LoginRequest;
import com.gym.pal.controller.dto.SocioRequest;
import com.gym.pal.model.Socio;
import com.gym.pal.controller.dto.SocioDto;
import com.gym.pal.repository.ISocioRepository;
import com.gym.pal.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SocioServiceImpl implements SocioService {
    @Autowired
    private ISocioRepository repository;

    private final Function<SocioRequest, Socio> mapToSocio = new SocioRequestToSocio();
    private final Function<Socio, SocioDto> mapToSocioDto = new SocioToSocioDto();

    @Override
    public SocioDto crear(SocioRequest request)
    {
        Socio socio = mapToSocio.apply(request);
        repository.crear(socio);
        return  mapToSocioDto.apply(socio);
    }

    @Override
    public SocioDto login(LoginRequest request) {
        Socio socio = repository
                .findByEmailAndPass(request.getEmail(), request.getPass())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        return mapToSocioDto.apply(socio);
    }
}
