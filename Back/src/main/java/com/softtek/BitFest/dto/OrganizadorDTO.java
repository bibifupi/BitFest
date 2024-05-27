package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Organizador;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrganizadorDTO {
    private int idOrganizador;

    @NotEmpty
    @Size(min = 3, max = 60)
    private String nombre;

    @NotEmpty
    @Size(min = 3, max = 500)
    private String logotipo;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String descripcionCorta;

    public Organizador castOrganizador() {
        Organizador organizador = new Organizador();
        organizador.setIdOrganizador(this.idOrganizador);
        organizador.setNombre(this.nombre);
        organizador.setLogotipo(this.logotipo);
        organizador.setDescripcionCorta(this.descripcionCorta);
        return organizador;
    }

    public OrganizadorDTO castDto(Organizador organizador) {
        this.idOrganizador = organizador.getIdOrganizador();
        this.nombre = organizador.getNombre();
        this.logotipo = organizador.getLogotipo();
        this.descripcionCorta = organizador.getDescripcionCorta();
        return this;
    }
}
