package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComentarioRepositorio extends IGenericoRepositorio<Comentario, Integer> {
    @Query("SELECT c FROM Comentario c WHERE c.idevento.eventoId = :eventoId")
    List<Comentario> findByEventoId(@Param("eventoId") int eventoId);
}
