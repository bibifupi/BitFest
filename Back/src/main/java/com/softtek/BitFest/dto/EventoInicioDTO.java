package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventoInicioDTO {
    private int idEvento;
    @NotEmpty
    @Size(min = 3, max = 60)
    private String titulo;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String descripcionCorta;
    @NotNull
    private LocalDate fechaRealizacion;
    @NotEmpty
    @Size(min = 3, max = 500)
    private String imagen;

    private Organizador organizador;

    public Evento castEventoInicio() {
        Evento e1 = new Evento();
        e1.setIdEvento(this.idEvento);
        e1.setTitulo(this.titulo);
        e1.setDescripcionCorta(this.descripcionCorta);
        e1.setFechaRealizacion(this.fechaRealizacion);
        e1.setImagen(this.imagen);
        e1.setOrganizador(this.organizador);
        return e1;
    }

    public EventoInicioDTO castEventoDTO(Evento e){
        idEvento=e.getIdEvento();
        titulo=e.getTitulo();
        descripcionCorta=e.getDescripcionCorta();
        fechaRealizacion=e.getFechaRealizacion();
        imagen=e.getImagen();
        organizador=e.getOrganizador();
        return this;
    }
}
