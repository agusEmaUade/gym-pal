package com.gym.pal.repository;

import com.gym.pal.model.Medicion;
import com.gym.pal.model.Socio;
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

    public Optional<Socio> findByEmail(String email) {
        return socios
                .stream()
                .filter(s -> email.equalsIgnoreCase(s.getEmail()))
                .findFirst();
    }

    public void actualizarMediciones(String email, Medicion nuevaMedicion) {
        Optional<Socio> socioOpt = findByEmail(email);

        socioOpt.ifPresent(socio -> {
            List<Medicion> mediciones = socio.getMediciones();

            if (mediciones == null) {
                mediciones = new ArrayList<>();
                socio.setMediciones(mediciones);
            }

            mediciones.add(nuevaMedicion);
        });
    }

}
