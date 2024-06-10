package com.softtek.BitFest.servicio;


import com.softtek.BitFest.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUsuarioServicio extends ICRUD<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional <Usuario> findByEmail(String email);

    UserDetailsService userDetailsService();
}
