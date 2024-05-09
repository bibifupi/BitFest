package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio usuRepo;

    @Override
    protected IGenericoRepositorio<Usuario, Integer> getRepo() {
        return usuRepo;
    }
}
