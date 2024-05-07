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
@Table(name = "eventos")
@Table(name = "eventos2")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventoId;

    private String titulo;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaActualizacion;
    private String estado;

    @OneToMany(mappedBy = "evento")
    private String imagenes;

    @ManyToOne
    @JoinColumn(name = "organizadorId")
    private Organizador organizador;
}