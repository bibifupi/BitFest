package com.softtek.BitFest.servicio.Implementacion;


import com.softtek.BitFest.dto.response.JwtAuthenticationResponse;
import com.softtek.BitFest.dto.response.LoginRequest;
import com.softtek.BitFest.dto.response.RegistroRequest;
import com.softtek.BitFest.servicio.AuthenticationService;
import com.softtek.BitFest.servicio.JwtService;
import com.softtek.BitFest.modelo.Rol;
import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.repositorio.IUsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final IUsuarioRepositorio userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(RegistroRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .nombreUsuario(request.getNombreUsuario())
                .email(request.getEmail())
                .contraseña(passwordEncoder.encode(request.getContraseña()))
                .imagen(request.getImagen()).rol(Rol.USER)
                .build();

        userRepository.save(usuario);
        var jwt = jwtService.generateToken( usuario);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContraseña()));
        var usuario = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken((UserDetails) usuario);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}