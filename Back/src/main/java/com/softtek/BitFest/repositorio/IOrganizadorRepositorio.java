package com.softtek.BitFest.repositorio;


import com.softtek.BitFest.modelo.Organizador;

import java.util.List;

public interface IOrganizadorRepositorio  extends IGenericoRepositorio<Organizador,Integer>{
    List<Organizador> findFirst7ByNombre(String nombre);
    List<Organizador> findByNombreLike(String nombre);
}
