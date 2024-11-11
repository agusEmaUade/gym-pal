package com.gym.pal.repository;

import com.gym.pal.model.Medicion;
import com.gym.pal.model.Socio;
import com.gym.pal.service.objetivo.Objetivo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SocioRepository implements ISocioRepository{
    private List<Socio> socios = new ArrayList<>();

    public List<Socio> getAllSocio() {
        return socios;
    }

    public Socio crear(Socio socio) {
        socios.add(socio);
        return socio;
    }

    public Optional<Socio> findByEmailAndPass(String email, String pass) {
        return socios
                .stream()
                .filter(s -> email.equalsIgnoreCase(s.getEmail()) && pass.equalsIgnoreCase(s.getPass()))
                .findFirst();
    }

    public Optional<Socio> findById(String id) {
        return socios
                .stream()
                .filter(s -> id.equalsIgnoreCase(s.getId()))
                .findFirst();
    }

    public void actualizarMediciones(String socioId, Medicion nuevaMedicion) {
        Optional<Socio> socioOpt = findById(socioId);

        socioOpt.ifPresent(socio -> {
            List<Medicion> mediciones = socio.getMediciones();

            if (mediciones == null) {
                mediciones = new ArrayList<>();
                socio.setMediciones(mediciones);
            }

            mediciones.add(nuevaMedicion);
        });
    }

    public void setearObjetivo(String socioId, Objetivo objetivo) {
        Optional<Socio> socioOpt = findById(socioId);

        socioOpt.ifPresent(socio -> {
           socio.setObjetivo(objetivo);
        });
    }

    public void actualizarTrofeos(String socioId, String trofeo) {
        Optional<Socio> socioOpt = findById(socioId);

        socioOpt.ifPresent(socio -> {
            List<String> trofeos = socio.getTrofeos();

            if (trofeos == null) {
                trofeos = new ArrayList<>();
                socio.setTrofeos(trofeos);
            }

            trofeos.add(trofeo);
        });
    }

}
