package com.gym.pal.service.autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacionImpl implements IAutenticacion {
    private static List<String> PASS_OK = List.of("123", "345");

    @Override
    public boolean registrar(String email, String pass) {
        return true;
    }

    @Override
    public boolean login(String email, String pass) {
        return PASS_OK.stream().anyMatch(p -> p.equalsIgnoreCase(pass));
    }
}
