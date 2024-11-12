package com.gym.pal.service.observer;

import com.gym.pal.dto.TipoDeTrofeoDto;
import com.gym.pal.model.Socio;

public interface IObserver {
    void agregarTrofeo(Socio socio, TipoDeTrofeoDto trofeoDto);
}
