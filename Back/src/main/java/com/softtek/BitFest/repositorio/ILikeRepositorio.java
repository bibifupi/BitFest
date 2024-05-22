package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Like;

import java.util.List;

public interface ILikeRepositorio extends IGenericoRepositorio<Like,Integer> {
    // Buscar likes por usuario
    List<Like> findByUsuarioId(Integer usuarioId);

    // Contar el número de likes de un usuario
    long countByUsuarioId(Integer usuarioId);

    // Verificar si un usuario ha dado like a un cierto post
    boolean existsByUsuarioIdAndPostId(Integer usuarioId, Integer postId);
}
