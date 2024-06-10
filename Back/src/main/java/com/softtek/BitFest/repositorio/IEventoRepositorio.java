package com.softtek.BitFest.repositorio;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.softtek.BitFest.modelo.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface IEventoRepositorio extends IGenericoRepositorio<Evento,Integer>{

    List<Evento> findFirst7ByFechaRealizacionGreaterThanEqualOrderByFechaRealizacionAsc(LocalDate fecha);
    List<Evento> findByTituloLike(String titulo);
    List<Evento> findAllByOrderByFechaRealizacion();
    List<Evento> findByOrganizador_NombreOrderByOrganizador_Nombre(String nombre);
    List<Evento> findByTituloContainingIgnoreCaseOrOrganizador_NombreContainingIgnoreCase(String titulo, String nombre);
}
