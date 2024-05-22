package com.softtek.BitFest.servicio.Implementacion;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.repositorio.IEventoRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.servicio.IEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class EventoImpl extends CRUDImpl<Evento, Integer> implements IEventoServicio {

    @Autowired
    private IEventoRepositorio eventoRepo;

    @Override
    protected IGenericoRepositorio<Evento, Integer> getRepo() {
        return eventoRepo;
    }

}
