package com.softtek.BitFest.repositorio;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.modelo.Usuario;

import java.util.List;

public interface IUsuarioRepositorio extends IGenericoRepositorio<Usuario,Integer> {
    List<Usuario> findByNombreAsc(String nombre);
    List<Usuario> findByContenerLetra(String nombre);
    //List<Usuario> findByCorreo(String correo);

}
