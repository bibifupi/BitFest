package com.softtek.BitFest.servicio.Implementacion;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;

import com.softtek.BitFest.repositorio.IUsuarioRepositorio;

import com.softtek.BitFest.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class UsuarioImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepo;

    @Override
    protected IGenericoRepositorio<Usuario, Integer> getRepo() {
        return usuarioRepo;
    }

    @Override
    public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepo.findByEmail(email);
    }


};
