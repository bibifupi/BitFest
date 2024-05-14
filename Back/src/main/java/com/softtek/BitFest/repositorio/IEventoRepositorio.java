package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEventoRepositorio  extends IGenericoRepositorio<Evento,Integer>{
    List<Evento>findFirst7ByFechaInicio(String fechaInicio);

    List<Evento>findByTituloLike(String titulo);

    @Query("select e.organizador from Evento e where e.organizador.nombre = :nombre")
    List<Organizador> consultaEventoPorOrganizador(@Param("nombre") String nombre);
}
