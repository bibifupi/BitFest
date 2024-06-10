package com.softtek.BitFest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroRequest {
    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private String email;
    private String contraseña;
    private String imagen;
}