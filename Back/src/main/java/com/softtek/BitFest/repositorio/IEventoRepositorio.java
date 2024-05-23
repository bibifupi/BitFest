package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Evento;

import java.time.LocalDate;
import java.util.List;

public interface IEventoRepositorio extends IGenericoRepositorio<Evento,Integer>{
    List<Evento> findFirst7ByFechaRealizacion(LocalDate fechaRealizacion);
    List<Evento> findByTituloLike(String titulo);
    List<Evento> findAllByOrderByFechaRealizacion();
    List<Evento> findByOrganizador_NombreOrderByOrganizador_Nombre(String busqueda);
}
