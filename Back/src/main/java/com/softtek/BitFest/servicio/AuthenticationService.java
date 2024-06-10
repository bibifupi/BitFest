package com.softtek.BitFest.servicio;


import com.softtek.BitFest.dto.response.JwtAuthenticationResponse;
import com.softtek.BitFest.dto.response.LoginRequest;
import com.softtek.BitFest.dto.response.RegistroRequest;



public interface AuthenticationService {
    JwtAuthenticationResponse signin(LoginRequest request);

    JwtAuthenticationResponse signup(RegistroRequest request);

}