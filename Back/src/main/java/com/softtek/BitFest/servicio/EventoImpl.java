package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.repositorio.IComentarioRepositorio;
import com.softtek.BitFest.repositorio.IEventoRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoImpl extends CRUDImpl<Evento, Integer> implements IEventoServicio {
    @Autowired
    private IEventoRepositorio eventRepo;

    @Override
    protected IGenericoRepositorio<Evento, Integer> getRepo() { return eventRepo;
    }
}
