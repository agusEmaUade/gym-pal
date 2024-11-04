package com.gym.pal.controller;

import com.gym.pal.controller.dto.LoginRequest;
import com.gym.pal.controller.dto.SocioRequest;
import com.gym.pal.domain.dto.SocioDto;
import com.gym.pal.service.SocioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gym.pal.controller.Path.*;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class SocioController {

    @Autowired
    private SocioService service;

    @PostMapping(CREATE_SOCIO)
    public SocioDto crearSocio(
            @Valid @RequestBody SocioRequest dto) {
        return service.crear(dto);
    }

    @PostMapping(LOGIN)
    public SocioDto login(
            @Valid @RequestBody LoginRequest dto) {
        return service.login(dto);
    }
}
