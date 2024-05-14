package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.repositorio.IComentarioRepositorio;
import com.softtek.BitFest.repositorio.IEventoRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoImpl extends CRUDImpl<Evento, Integer> implements IEventoServicio {
    @Autowired
    private IEventoRepositorio eventRepo;

    @Override
    protected IGenericoRepositorio<Evento, Integer> getRepo() { return eventRepo;
    }

    @Override
    public List<Evento> findFirst7ByFechaInicio(String fechaInicio) {
        return eventRepo.findFirst7ByFechaInicio(fechaInicio);
    }

    @Override
    public List<Evento> findByTituloLike(String titulo) {
        return eventRepo.findByTituloLike(titulo);
    }

    @Override
    public List<Evento> consultaEventoPorOrganizador(String nombre) {
        return eventRepo.consultaEventoPorOrganizador(nombre);
    }
}
