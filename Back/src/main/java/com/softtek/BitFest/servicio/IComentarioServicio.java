package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.repositorio.IComentarioRepositorio;

import java.util.List;

public interface IComentarioServicio extends ICRUD<Comentario, Integer>  {
    List<Comentario> findByEventoId(int eventoId);
}
