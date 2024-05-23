package com.softtek.BitFest.repositorio;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.softtek.BitFest.modelo.Evento;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface IEventoRepositorio extends IGenericoRepositorio<Evento,Integer>{
    List<Evento> findFirst7ByFechaRealizacion(LocalDate fechaRealizacion);
    List<Evento> findByTituloLike(String titulo);
    List<Evento> findAllByOrderByFechaRealizacion();
    List<Evento> findByOrganizador_NombreOrderByOrganizador_Nombre(String busqueda);
}
