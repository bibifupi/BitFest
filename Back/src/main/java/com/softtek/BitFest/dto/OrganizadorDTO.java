package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Organizador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrganizadorDTO {
    private int organizadorId;
    @NotNull
    private String nombre;
    @NotNull
    private String logotipo;
    @NotNull
    private String descripcionCorta;
    @NotNull
    private String descripcionLarga;

    public Organizador castOrganizador() {
        Organizador o1 = new Organizador();
        o1.setOrganizadorId(this.organizadorId);
        o1.setNombre(this.nombre);
        o1.setLogotipo(this.logotipo);
        o1.setDescripcionCorta(this.descripcionCorta);
        o1.setDescripcionLarga(this.descripcionLarga);
        return o1;
    }

    public OrganizadorDTO castOrganizadorDTO(Organizador o) {
        organizadorId = o.getOrganizadorId();
        nombre = o.getNombre();
        logotipo = o.getLogotipo();
        descripcionCorta = o.getDescripcionCorta();
        descripcionLarga = o.getDescripcionLarga();
        return this;
    }
}
