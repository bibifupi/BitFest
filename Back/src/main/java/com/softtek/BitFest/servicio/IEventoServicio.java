package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Evento;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface IEventoServicio  extends ICRUD<Evento, Integer>{
    List<Evento> findFirst7ByFechaRealizacionGreaterThanEqual();
    List<Evento> findByTituloLike(String titulo);
    List<Evento> findAllByOrderByFechaRealizacion();
    List<Evento> findByOrganizador_NombreOrderByOrganizador_Nombre(String Busqueda);
    List<Evento> buscarEventos(String query);

}
