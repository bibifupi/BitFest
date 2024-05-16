package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.EventoCategoria;
import com.softtek.BitFest.repositorio.IEventoCategoriaRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoCategoriaImpl extends CRUDImpl<EventoCategoria, Integer> implements IEventoCategoriaServicio {
    @Autowired
    private IEventoCategoriaRepositorio eventCatRepo;

    @Override
    protected IGenericoRepositorio<EventoCategoria, Integer> getRepo() {
        return eventCatRepo;
    }

    @Override
    public List<Evento> findByCategoriaLike(String nombre) {
        return eventCatRepo.findByCategoriaLike();
    }
}
