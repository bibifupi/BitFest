package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Comentario;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IComentarioServicio extends ICRUD<Comentario, Integer>{
    List<Comentario> findByEvento_IdEvento(int idEvento);
}
