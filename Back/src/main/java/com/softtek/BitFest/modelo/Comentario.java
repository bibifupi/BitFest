package com.softtek.BitFest.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comentarioId;
    @Column (length = 500, nullable = false)
    private String texto;
    @Column (length = 60, nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "eventoId")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
}
