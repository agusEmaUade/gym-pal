package com.gym.pal.service;

import com.gym.pal.controller.dto.LoginRequest;
import com.gym.pal.controller.dto.SocioRequest;
import com.gym.pal.domain.dto.SocioDto;

public interface SocioService {
    SocioDto crear(SocioRequest request);
    SocioDto login(LoginRequest request);
}
