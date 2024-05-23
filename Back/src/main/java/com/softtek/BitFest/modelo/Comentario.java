package com.softtek.BitFest.modelo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    @Column (length = 500, nullable = false)
    private String texto;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
}
