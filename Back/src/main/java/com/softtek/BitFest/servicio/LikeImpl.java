package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Like;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.ILikeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeImpl extends CRUDImpl<Like, Integer> implements ILikeServicio {
    @Autowired
    private ILikeRepositorio catRepo;

    @Override
    protected IGenericoRepositorio<Like, Integer> getRepo() {
        return catRepo;
    }
}
