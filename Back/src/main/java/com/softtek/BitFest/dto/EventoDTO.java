package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EventoDTO {
    private int idEvento;
    @NotEmpty
    @Size(min = 3, max = 60)
    private String titulo;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String descripcionCorta;
    @NotEmpty
    @Size(min = 10, max = 500)
    private String descripcionLarga;
    @NotNull
    private LocalDate fechaRealizacion;
    @NotNull
    private LocalDate fechaActualizacion;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String categoria;
    @NotEmpty
    @Size(min = 3, max = 500)
    private String imagen;
    @NotNull
    private Organizador organizador;

    public Evento castEvento() {
        Evento e1 = new Evento();
        e1.setIdEvento(this.idEvento);
        e1.setTitulo(this.titulo);
        e1.setDescripcionCorta(this.descripcionCorta);
        e1.setDescripcionLarga(this.descripcionLarga);
        e1.setFechaRealizacion(this.fechaRealizacion);
        e1.setFechaActualizacion(this.fechaActualizacion);
        e1.setCategoria(this.categoria);
        e1.setImagen(this.imagen);
        e1.setOrganizador(this.organizador);
        return e1;
    }
    public EventoDTO castEventoDTO(Evento e){
        idEvento=e.getIdEvento();
        titulo=e.getTitulo();
        descripcionCorta=e.getDescripcionCorta();
        descripcionLarga=e.getDescripcionLarga();
        fechaRealizacion=e.getFechaRealizacion();
        fechaActualizacion=e.getFechaActualizacion();
        categoria=e.getCategoria();
        imagen=e.getImagen();
        organizador=e.getOrganizador();
        return this;
    }
}
