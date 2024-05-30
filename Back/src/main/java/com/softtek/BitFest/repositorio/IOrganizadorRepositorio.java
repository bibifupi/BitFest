package com.softtek.BitFest.repositorio;


import com.softtek.BitFest.modelo.Organizador;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrganizadorRepositorio  extends IGenericoRepositorio<Organizador,Integer>{
    @Query("SELECT o FROM Organizador o ORDER BY o.nombre ASC LIMIT 7")
    List<Organizador> findTop7OrganizersByName();
    List<Organizador> findByNombreLike(String nombre);
}
