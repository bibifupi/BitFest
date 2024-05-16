package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Categoria;

import java.util.List;

public interface ICategoriaRepositorio extends IGenericoRepositorio<Categoria,Integer> {
    // Buscar categorías por nombre
    List<Categoria> findByNombre(String nombre);

    // Buscar categorías que contengan una cierta palabra en su nombre
    List<Categoria> findByNombreContaining(String palabra);

    // Contar el número de categorías con un cierto nombre
    long countByNombre(String nombre);

    // Verificar si existe una categoría con un cierto nombre
    boolean existsByNombre(String nombre);
}

