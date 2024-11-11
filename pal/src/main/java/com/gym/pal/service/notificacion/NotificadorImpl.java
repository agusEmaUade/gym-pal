package com.gym.pal.service.notificacion;

import com.gym.pal.dto.Notificacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificadorImpl implements INotificador {

    @Override
    public void notificar(Notificacion notificacion) {
        log.info("Se envio una notificacion");
    }
}
