package com.softtek.BitFest.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventoId;
    @Column(length = 60, nullable = false)
    private String titulo;
    @Column(length = 100, nullable = false)
    private String descripcionCorta;
    @Column(length = 500, nullable = false)
    private String descripcionLarga;
    @Column(length = 60, nullable = false)
    private Date fechaInicio;
    @Column(length = 60, nullable = false)
    private Date fechaActualizacion;
    @Column(length = 60, nullable = false)
    private String estado;
    @Column(length = 100, nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "organizadorId")
    private Organizador organizador;
}