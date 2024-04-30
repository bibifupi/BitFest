package com.softtek.BitFest.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evento_categorias")
public class EventoCategoria {
    @Id
    @ManyToOne
    @JoinColumn(name = "eventoId")
    private Evento evento;

    @Id
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;
}
