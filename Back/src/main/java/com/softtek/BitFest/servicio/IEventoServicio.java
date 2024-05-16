package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEventoServicio extends ICRUD<Evento,Integer> {
    List<Evento> findFirst7ByFechaInicio(String fechaInicio);

    List<Evento>findByTituloLike(String titulo);

    List<Organizador> consultaEventoPorOrganizador(@Param("nombre") String nombre);
}
