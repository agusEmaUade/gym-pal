package com.gym.pal.service.impl;

import com.gym.pal.controller.dto.LoginSocioDto;
import com.gym.pal.controller.dto.CreateSocioDto;
import com.gym.pal.model.Socio;
import com.gym.pal.controller.dto.SocioDto;
import com.gym.pal.repository.ISocioRepository;
import com.gym.pal.service.SocioService;
import com.gym.pal.service.autenticacion.IAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class SocioServiceImpl implements SocioService {
    @Autowired
    private ISocioRepository repository;

    @Autowired
    private IAutenticacion autenticacionService;

    private final Function<CreateSocioDto, Socio> mapToSocio = new SocioRequestToSocio();
    private final Function<Socio, SocioDto> mapToSocioDto = new SocioToSocioDto();

    @Override
    public SocioDto crear(CreateSocioDto request) {
        Optional<Socio> socioBd = repository
                .findByEmailAndPass(request.getEmail(), request.getPass());

        if (socioBd.isPresent()) {
            throw new RuntimeException("socio ya registrado");
        }

        Socio socio = mapToSocio.apply(request);
        repository.crear(socio);
        if (!autenticacionService.registrar(request.getEmail(), request.getPass())) {
            throw new RuntimeException("no se pudo registrar");
        }

        return mapToSocioDto.apply(socio);
    }

    @Override
    public SocioDto login(LoginSocioDto request) {
        Socio socio = repository
                .findByEmailAndPass(request.getEmail(), request.getPass())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        if (!autenticacionService.login(request.getEmail(), request.getPass())) {
            throw new RuntimeException("Socio no registrar");
        }

        return mapToSocioDto.apply(socio);
    }
}
