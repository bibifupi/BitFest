package com.softtek.BitFest.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvento;
    @Column(length = 60, nullable = false)
    private String titulo;
    @Column(length = 100, nullable = false)
    private String descripcionCorta;
    @Column(length = 500, nullable = false)
    private String descripcionLarga;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRealizacion;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;
    @Column(length = 100, nullable = false)
    private String categoria;
    @Column(length = 500, nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "idOrganizador")
    private Organizador organizador;
}
