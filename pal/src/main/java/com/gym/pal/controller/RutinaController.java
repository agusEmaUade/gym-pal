package com.gym.pal.controller;

import com.gym.pal.dto.EjercicioDto;
import com.gym.pal.service.RutinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.gym.pal.controller.Path.*;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class RutinaController {

    @Autowired
    private RutinaService service;

    @PostMapping(RUTINA_BASE)
    public void registrarEjercicio(
            @Valid @RequestHeader String socioId,
            @Valid @RequestBody EjercicioDto dto) {
        service.registrar(dto, socioId);
    }
}
