package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.EventoCategoria;

import java.util.List;

public interface IEventoCategoriaServicio extends ICRUD<EventoCategoria,Integer> {
    List<Evento> findByCategoriaLike(String nombre);
}
