package com.softtek.BitFest.servicio;


import com.softtek.BitFest.response.JwtAuthenticationResponse;
import com.softtek.BitFest.dto.request.SignInRequest;
import com.softtek.BitFest.dto.request.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);

}