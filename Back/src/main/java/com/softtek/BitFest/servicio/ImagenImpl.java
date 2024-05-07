package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Imagen;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenImpl extends CRUDImpl<Imagen, Integer> implements IImagenServicio {
    @Autowired
    private IImagenRepositorio imgRepo;
    @Override
    protected IGenericoRepositorio<Imagen, Integer> getRepo() {
        return imgRepo;
    }
}
