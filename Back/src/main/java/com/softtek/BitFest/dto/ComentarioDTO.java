package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComentarioDTO {
    @NotNull
    private int idComentario;

    @NotEmpty
    private String texto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @NotNull
    private Evento idEvento;

    @NotNull
    private Usuario idUsuario;

    public Comentario castComentario() {
        Comentario comentario = new Comentario();
        comentario.setIdComentario(this.idComentario);
        comentario.setTexto(this.texto);
        comentario.setFecha(this.fecha);
        comentario.setEvento(this.idEvento);
        comentario.setIdUsuario(this.idUsuario);
        return comentario;
    }

    public static ComentarioDTO fromEntity(Comentario comentario) {
        return new ComentarioDTO(
                comentario.getIdComentario(),
                comentario.getTexto(),
                comentario.getFecha(),
                comentario.getEvento(),
                comentario.getIdUsuario()
        );
    }
}