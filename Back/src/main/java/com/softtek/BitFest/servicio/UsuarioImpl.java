package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio usuRepo;

    @Override
    protected IGenericoRepositorio<Usuario, Integer> getRepo() {
        return usuRepo;
    }

    @Override
    public Usuario findByNombreAsc(String nombre) {
        return (Usuario) usuRepo.findByNombreAsc(nombre);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                Usuario user = (Usuario) usuRepo.findByNombreAsc(username);
                if (user == null) {
                    throw new UsernameNotFoundException("Usuario no encontrado");
                }
                return (UserDetails) user;
            }
        };
    }

}
