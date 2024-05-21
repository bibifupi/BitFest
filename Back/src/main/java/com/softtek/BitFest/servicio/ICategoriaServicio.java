package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;

import java.util.List;

public interface ICategoriaServicio extends ICRUD<Categoria,Integer> {
    List<Categoria> findByNombre(String nombre);
    List<Categoria> findByNombreContaining(String palabra);
    long countByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
