package com.gym.pal.controller;

import com.gym.pal.dto.LoginSocioDto;
import com.gym.pal.dto.CreateSocioDto;
import com.gym.pal.dto.MedicionDto;
import com.gym.pal.dto.SocioDto;
import com.gym.pal.service.SocioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.gym.pal.controller.Path.*;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class SocioController {

    @Autowired
    private SocioService service;

    @PostMapping(CREATE_SOCIO)
    public SocioDto crearSocio(
            @Valid @RequestBody CreateSocioDto dto) {
        return service.crear(dto);
    }

    @PostMapping(LOGIN)
    public SocioDto login(
            @Valid @RequestBody LoginSocioDto dto) {
        return service.login(dto);
    }

    @PostMapping(MEDICION_PESO)
    public String registroPeso(
            @Valid @RequestHeader String socioId,
            @Valid @RequestBody MedicionDto dto) {
        return service.registroPeso(socioId, dto);
    }

    @PostMapping(SET_OBJETIVO)
    public String registrarObjetivo(
            @Valid @RequestHeader String socioId,
            @PathVariable String  tipoObjetivo) {
        return service.registrarObjetivo(socioId, tipoObjetivo);
    }
}
