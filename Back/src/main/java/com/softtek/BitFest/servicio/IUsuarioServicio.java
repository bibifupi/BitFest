package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.Usuario;

public interface IUsuarioServicio extends ICRUD<Usuario,Integer> {
    <List>Usuario findByNombreAsc(String nombre);
}
