package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComentarioRepositorio extends IGenericoRepositorio<Comentario,Integer> {
    List<Comentario> findByEvento_IdEvento(@Param("idEvento") int idEvento);
}
