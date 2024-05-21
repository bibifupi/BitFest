package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.repositorio.ICategoriaRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaImpl extends CRUDImpl<Categoria, Integer> implements ICategoriaServicio {
    @Autowired
    private ICategoriaRepositorio catRepo;

    @Override
    protected IGenericoRepositorio<Categoria, Integer> getRepo() {
        return catRepo;
    }

    // Implementación de los métodos de ICategoriaRepositorio
    @Override
    public List<Categoria> findByNombre(String nombre) {
        return catRepo.findByNombre(nombre);
    }

    @Override
    public List<Categoria> findByNombreContaining(String palabra) {
        return catRepo.findByNombreContaining(palabra);
    }

    @Override
    public long countByNombre(String nombre) {
        return catRepo.countByNombre(nombre);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return catRepo.existsByNombre(nombre);
    }
}
