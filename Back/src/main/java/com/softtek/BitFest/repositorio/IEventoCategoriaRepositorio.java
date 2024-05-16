package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.EventoCategoria;

import java.util.List;

public interface IEventoCategoriaRepositorio extends IGenericoRepositorio<EventoCategoria,Integer>{
    List<Evento> findByCategoriaLike();
}
