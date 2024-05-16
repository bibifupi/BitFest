package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Organizador;

import java.util.List;

public interface IOrganizadorServicio extends ICRUD<Organizador,Integer> {
    List<Organizador> findByNombreAsc(String nombre);
    List<Organizador> findFirst6ByNombre(String nombre);
    List<Organizador> findByNombreLike(String nombre);

}
