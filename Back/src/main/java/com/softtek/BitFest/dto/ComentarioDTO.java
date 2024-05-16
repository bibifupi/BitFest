package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComentarioDTO {
    private int comentarioId;
    @NotNull
    private String texto;
    @NotNull
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public Comentario castComentario() {
        Comentario c1 = new Comentario();
        c1.setComentarioId(this.comentarioId);
        c1.setTexto(this.texto);
        c1.setFecha(this.fecha);
        c1.setUsuario(this.usuario);
        return c1;

    }

    public ComentarioDTO castComentarioDTO(Comentario c) {
        comentarioId = c.getComentarioId();
        texto = c.getTexto();
        fecha = c.getFecha();
        usuario = c.getUsuario();
        return this;
    }


}
