package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.Organizador;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoDTO {
    private int eventoId;
    @NotNull
    private String titulo;
    @NotNull
    private String descripcionCorta;
    @NotNull
    private String descripcionLarga;
    @NotNull
    private Date fechaInicio;
    @NotNull
    private String estado;
    @NotNull
    private String imagen;
    @NotNull
    private Organizador organizador;

    public Evento castEvento() {
        Evento e1 = new Evento();
        e1.setEventoId(this.eventoId);
        e1.setTitulo(this.titulo);
        e1.setDescripcionCorta(this.descripcionCorta);
        e1.setDescripcionLarga(this.descripcionLarga);
        e1.setFechaInicio(this.fechaInicio);
        e1.setEstado(this.estado);
        e1.setImagen(this.imagen);
        e1.setOrganizador(this.organizador);
        return e1;
    }

    public EventoDTO castEventoDTO(Evento e) {
        eventoId = e.getEventoId();
        titulo = e.getTitulo();
        descripcionCorta = e.getDescripcionCorta();
        descripcionLarga = e.getDescripcionLarga();
        fechaInicio = e.getFechaInicio();
        estado = e.getEstado();
        imagen=e.getImagen();
        organizador=e.getOrganizador();
        return this;
    }
}
