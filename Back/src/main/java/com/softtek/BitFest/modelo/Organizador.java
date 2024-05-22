package com.softtek.BitFest.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizadores")
public class Organizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrganizador;
    @Column (length = 60, nullable = false)
    private String nombre;
    @Column (length = 500, nullable = false)
    private String logotipo;
    @Column (length = 100, nullable = false)
    private String descripcionCorta;
    @Column (length = 500, nullable = false)
    private String descripcionLarga;
}