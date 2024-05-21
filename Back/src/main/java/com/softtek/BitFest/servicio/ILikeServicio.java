package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Like;

import java.util.List;

public interface ILikeServicio extends ICRUD<Like,Integer> {
    List<Like> findByUsuarioId(Integer usuarioId);
    long countByUsuarioId(Integer usuarioId);
    boolean existsByUsuarioIdAndPostId(Integer usuarioId, Integer postId);
}
