package com.gym.pal.dto;

import com.gym.pal.model.Socio;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Notificacion {
    private String mensaje;
    private String descripcion;
    private Socio socio;
}
