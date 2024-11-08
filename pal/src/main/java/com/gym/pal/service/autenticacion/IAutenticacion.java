package com.gym.pal.service.autenticacion;

public interface IAutenticacion {
    boolean registrar(String email, String pass);

    boolean login(String email, String pass);
}
