package com.softtek.BitFest.servicio.Implementacion;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.repositorio.IComentarioRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;


public class ComentarioImpl extends CRUDImpl<Comentario, Integer> implements IComentarioServicio {

    @Autowired
    private IComentarioRepositorio comentarioRepo;

    @Override
    protected IGenericoRepositorio<Comentario, Integer> getRepo() {
        return comentarioRepo;
    }

}
