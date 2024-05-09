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

}
