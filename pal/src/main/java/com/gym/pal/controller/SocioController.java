package com.gym.pal.controller;

import static com.gym.pal.controller.Path.BASE_PATH;
import static com.gym.pal.controller.Path.CREATE_SOCIO;

import com.gym.pal.controller.dto.SocioRequest;
import com.gym.pal.service.SocioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class SocioController {

    @Autowired
    private SocioService service;

    @PostMapping(CREATE_SOCIO)
    public SocioDto createBook(
            @Valid @RequestBody SocioRequest dto) {
        return service.crearSocio(dto);
    }
}
