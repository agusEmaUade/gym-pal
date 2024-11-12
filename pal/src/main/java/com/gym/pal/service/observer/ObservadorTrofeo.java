package com.gym.pal.service.observer;

import com.gym.pal.dto.TipoDeTrofeoDto;
import com.gym.pal.model.Socio;
import com.gym.pal.model.Trofeo;
import com.gym.pal.repository.ISocioRepository;
import com.gym.pal.service.impl.TrofeoDtoToTrofeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ObservadorTrofeo implements IObserver {

    @Autowired
    private ISocioRepository repository;
    private final Function<TipoDeTrofeoDto, Trofeo> mapToTrofeo = new TrofeoDtoToTrofeo();

    public void agregarTrofeo(Socio socio, TipoDeTrofeoDto trofeoDto) {
        Trofeo trofeoNuevo = mapToTrofeo.apply(trofeoDto);
        repository.actualizarTrofeos(socio.getId(), trofeoNuevo);
    }
}
