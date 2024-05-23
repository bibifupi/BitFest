package com.softtek.BitFest.servicio.Implementacion;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.repositorio.IEventoRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.servicio.IEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoImpl extends CRUDImpl<Evento, Integer> implements IEventoServicio {

    @Autowired
    private IEventoRepositorio eventoRepo;

    @Override
    protected IGenericoRepositorio<Evento, Integer> getRepo() {
        return eventoRepo;
    }

    @Override
    public List<Evento> findFirst7ByFechaRealizacion(LocalDate fechaRealizacion) {
        return eventoRepo.findFirst7ByFechaRealizacion(fechaRealizacion);
    }

    @Override
    public List<Evento> findByTituloLike(String titulo) {
        return eventoRepo.findByTituloLike(titulo);
    }

    @Override
    public List<Evento> findAllByOrderByFechaRealizacion() {
        return eventoRepo.findAllByOrderByFechaRealizacion();
    }
    @Override
    public List<Evento> findByOrganizador_NombreOrderByOrganizador_Nombre(String Busqueda) {
        return eventoRepo.findByOrganizador_NombreOrderByOrganizador_Nombre(Busqueda);
    }
}
