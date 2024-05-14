package com.softtek.BitFest.modelo;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;
    private String rol;
    private String nombre;
    private String email;
    private String contraseña;
    private Date fechaRegistro;
    private String imagen;

}
