package com.gym.pal.controller;

import com.gym.pal.controller.dto.LoginSocioDto;
import com.gym.pal.controller.dto.CreateSocioDto;
import com.gym.pal.controller.dto.SocioDto;
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
            @Valid @RequestBody CreateSocioDto dto) {
        return service.crear(dto);
    }

    @PostMapping(LOGIN)
    public SocioDto login(
            @Valid @RequestBody LoginSocioDto dto) {
        return service.login(dto);
    }
}
