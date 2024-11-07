package com.gym.pal.controller;

public interface Path {
    String BASE_PATH = "/api/gym";

    //---------
    //  SOCIO
    //---------
    String SOCIO_BASE = "/socio";
    String CREATE_SOCIO = SOCIO_BASE;
    String LOGIN = SOCIO_BASE + "/login";
    String GET_SOCIO = SOCIO_BASE + "/{id}";
}
