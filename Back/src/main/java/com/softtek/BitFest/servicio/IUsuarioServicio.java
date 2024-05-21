package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioServicio extends ICRUD<Usuario,Integer> {
    <List>Usuario findByNombreAsc(String nombre);

    UserDetailsService userDetailsService();



}
