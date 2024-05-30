package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Organizador;

import java.util.List;

public interface IOrganizadorServicio extends ICRUD<Organizador, Integer> {
    List<Organizador> findTop7OrganizersByName();
    List<Organizador> findByNombreLike(String nombre);
}
