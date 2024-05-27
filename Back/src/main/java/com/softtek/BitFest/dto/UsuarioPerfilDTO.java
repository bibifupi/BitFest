package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Rol;
import com.softtek.BitFest.modelo.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioPerfilDTO {
    private int idUsuario;
    @NotEmpty
    @Size(min = 3, max = 60)
    private String nombre;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String apellidos;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nombreUsuario;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String email;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String imagen;
    @NotEmpty
    @Size(min = 3, max = 5)
    private Rol rol;

    public Usuario castUsuario(){
        Usuario u1 = new Usuario();
        u1.setIdUsuario(this.idUsuario);
        u1.setNombre(this.nombre);
        u1.setApellidos(this.apellidos);
        u1.setNombreUsuario(this.nombreUsuario);
        u1.setEmail(this.email);
        u1.setImagen(this.imagen);
        u1.setRol(this.rol);
        return u1;
    }

    public UsuarioPerfilDTO castUsuarioPerfilDTO(Usuario u){
        idUsuario=u.getIdUsuario();
        nombre=u.getNombre();
        apellidos=u.getApellidos();
        nombreUsuario=u.getNombreUsuario();
        email=u.getEmail();
        imagen=u.getImagen();
        rol=u.getRol();
        return this;
    }
}
