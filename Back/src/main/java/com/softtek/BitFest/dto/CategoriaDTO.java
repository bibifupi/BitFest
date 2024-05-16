package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO {
    private int categoriaId;
    @NotNull
    private String nombre;

    public Categoria castCategoria() {
        Categoria c1 = new Categoria();
        c1.setCategoriaId(this.categoriaId);
        c1.setNombre(this.nombre);
        return c1;
    }

    public CategoriaDTO castCategoriaDTO(Categoria c) {
        categoriaId = c.getCategoriaId();
        nombre = c.getNombre();
        return this;
    }

}
