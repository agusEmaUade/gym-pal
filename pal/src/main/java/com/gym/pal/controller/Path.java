package com.gym.pal.controller;

public interface Path {
    String BASE_PATH = "/api/gym";

    //---------
    //  SOCIO
    //---------
    String SOCIO_BASE = "/socio";
    String CREATE_SOCIO = SOCIO_BASE;
    String LOGIN = SOCIO_BASE + "/login";
    String MEDICION_PESO = SOCIO_BASE + "/peso";

    //---------
    //  RUTINA
    //---------
    String RUTINA_BASE = "/rutina";
}
