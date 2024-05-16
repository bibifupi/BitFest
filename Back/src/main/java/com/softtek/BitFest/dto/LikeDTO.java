package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Like;
import com.softtek.BitFest.modelo.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LikeDTO {
    private int likeId;

    @ManyToOne
    @JoinColumn(name = "eventoId")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public Like castLike() {
        Like l1 = new Like();
        l1.setLikeId(this.likeId);
        l1.setEvento(this.evento);
        l1.setUsuario(this.usuario);
        return l1;
    }

    public LikeDTO castLikeDTO(Like l) {
        likeId = l.getLikeId();
        evento = l.getEvento();
        usuario = l.getUsuario();
        return this;
    }
}
