package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.EventoCategoria;
import com.softtek.BitFest.repositorio.ICategoriaRepositorio;
import com.softtek.BitFest.repositorio.IEventoCategoriaRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoCategoriaImpl extends CRUDImpl<EventoCategoria, Integer> implements IEventoCategoriaServicio {
    @Autowired
    private IEventoCategoriaRepositorio eventCatRepo;

    @Override
    protected IGenericoRepositorio<EventoCategoria, Integer> getRepo() {
        return eventCatRepo;
    }
}
