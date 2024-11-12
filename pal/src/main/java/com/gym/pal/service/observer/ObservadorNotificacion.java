package com.gym.pal.service.observer;

import com.gym.pal.dto.Notificacion;
import com.gym.pal.dto.TipoDeTrofeoDto;
import com.gym.pal.model.Socio;
import com.gym.pal.service.notificacion.INotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservadorNotificacion implements IObserver {
    @Autowired
    private INotificador notificadorSerivice;

    public void agregarTrofeo(Socio socio, TipoDeTrofeoDto trofeoDto) {
        Notificacion not = Notificacion.builder()
                .socio(socio)
                .descripcion("segui asi")
                .mensaje("grande")
                .build();

        notificadorSerivice.notificar(not);
    }
}
