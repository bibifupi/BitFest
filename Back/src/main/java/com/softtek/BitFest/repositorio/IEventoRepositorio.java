package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEventoRepositorio extends IGenericoRepositorio<Evento, Integer> {
    List<Evento> findFirst7ByFechaInicio(String fechaInicio);

    List<Evento> findByTituloLike(String titulo);

    List<Evento> findAllByOrderByFechaInicio();

    //cruzar tablas organizador y evento con nativa
    @Query(value= "select * from Evento e, Organizador o where e.idOrganizador=o.idOrganizador and o.nombre = :nombre", nativeQuery = true)
    List<Evento> consultaEventoPorOrganizador(@Param("nombre") String nombre);
}
