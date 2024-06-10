package com.softtek.BitFest.servicio.Implementacion;

import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.servicio.IUsuarioServicio;
import com.softtek.BitFest.servicio.Implementacion.CRUDImpl;
import com.softtek.BitFest.servicio.UserService;
import com.softtek.BitFest.repositorio.IUsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public  class UserServiceImpl extends CRUDImpl<Usuario,Integer> implements IUsuarioServicio {

    private final IUsuarioRepositorio userRepository;

    @Override
    public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
        return userRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return userRepository.findByNombreUsuario(username).orElseThrow(()-> new UsernameNotFoundException("email no invalido"));
            }
        };
    }

    @Override
    protected IGenericoRepositorio<Usuario, Integer> getRepo() {
        return userRepository;
    }
}