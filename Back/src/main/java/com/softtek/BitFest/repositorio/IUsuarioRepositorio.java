package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Usuario;

import java.util.Optional;

public interface IUsuarioRepositorio  extends IGenericoRepositorio<Usuario,Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional <Usuario> findByEmail(String email);
}
