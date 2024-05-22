package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
    private int usuarioId;
    @NotNull
    private String rol;
    @NotNull
    private String nombre;
    @NotNull
    private String email;
    @NotNull
    private String contraseña;
    @NotNull
    private Date fechaRegistro;
    @NotNull
    private String imagen;

    public Usuario castUsuario() {
        Usuario u1 = new Usuario();
        u1.setUsuarioId(this.usuarioId);
        u1.setRol(this.rol);
        u1.setNombre(this.nombre);
        u1.setEmail(this.email);
        u1.setContraseña(this.contraseña);
        u1.setFechaRegistro(this.fechaRegistro);
        u1.setImagen(this.imagen);
        return u1;
    }

    public UsuarioDTO castUsuarioDTO(Usuario u) {
        usuarioId = u.getUsuarioId();
        rol = u.getRol();
        nombre = u.getNombre();
        email = u.getEmail();
        contraseña = u.getContraseña();
        fechaRegistro = u.getFechaRegistro();
        imagen = u.getImagen();
        return this;
    }
}
