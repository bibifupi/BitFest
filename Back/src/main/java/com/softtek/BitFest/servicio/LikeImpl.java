package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Like;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.ILikeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeImpl extends CRUDImpl<Like, Integer> implements ILikeServicio {
    @Autowired
    private ILikeRepositorio likeRepo;

    @Override
    protected IGenericoRepositorio<Like, Integer> getRepo() {
        return likeRepo;
    }

    // Implementación de los métodos de ILikeRepositorio
    @Override
    public List<Like> findByUsuarioId(Integer usuarioId) {
        return likeRepo.findByUsuarioId(usuarioId);
    }

    @Override
    public long countByUsuarioId(Integer usuarioId) {
        return likeRepo.countByUsuarioId(usuarioId);
    }

    @Override
    public boolean existsByUsuarioIdAndPostId(Integer usuarioId, Integer postId) {
        return likeRepo.existsByUsuarioIdAndPostId(usuarioId, postId);
    }
}
