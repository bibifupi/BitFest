package com.softtek.BitFest.servicio.Implementacion;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IOrganizadorRepositorio;
import com.softtek.BitFest.repositorio.IUsuarioRepositorio;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import com.softtek.BitFest.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepo;

    @Override
    protected IGenericoRepositorio<Usuario, Integer> getRepo() {
        return usuarioRepo;
    }
}
