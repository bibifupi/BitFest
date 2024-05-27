package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioLoginDTO {
    private int idUsuario;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nombreUsuario;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String email;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String contraseña;

    public Usuario castUsuarioLogin(){
        Usuario u1 = new Usuario();
        u1.setIdUsuario(this.idUsuario);
        u1.setNombreUsuario(this.nombreUsuario);
        u1.setEmail(this.email);
        u1.setContraseña(this.contraseña);
        return u1;
    }

    public UsuarioLoginDTO castUsuarioLoginDTO(Usuario u){
        idUsuario=u.getIdUsuario();
        nombreUsuario=u.getNombreUsuario();
        email=u.getEmail();
        contraseña=u.getContraseña();
        return this;
    }
}
