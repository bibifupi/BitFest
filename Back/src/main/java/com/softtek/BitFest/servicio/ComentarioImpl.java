package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.repositorio.IComentarioRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.servicio.CRUDImpl;
import com.softtek.BitFest.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioImpl extends CRUDImpl<Comentario, Integer> implements IComentarioServicio {

    @Autowired
    private IComentarioRepositorio comentRepo;

    @Override
    protected IGenericoRepositorio<Comentario, Integer> getRepo() {
        return comentRepo;
    }

    @Override
    public List<Comentario> findByEventoId(int eventoId) {
        return comentRepo.findByEventoId(eventoId);
    }
}
