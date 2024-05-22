package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Evento;

import java.util.List;

public interface IEventoRepositorio extends IGenericoRepositorio<Evento,Integer>{
    List<Evento> findFirst7ByFechaInicio(String fechaInicio);
    List<Evento> findByTituloLike(String titulo);
    List<Evento> findAllByOrderByFechaInicio();
}
