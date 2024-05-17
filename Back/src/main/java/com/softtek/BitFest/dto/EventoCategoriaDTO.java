package com.softtek.BitFest.dto;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.modelo.EventoCategoria;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EventoCategoriaDTO {

    private Evento evento;

    private Categoria categoria;

    public EventoCategoria castEventoCategoria() {
        EventoCategoria ec1 = new EventoCategoria();
        ec1.setEvento(this.evento);
        ec1.setCategoria(this.categoria);
        return ec1;
    }

    public EventoCategoriaDTO castEventoCategoriaDTO(EventoCategoria ec) {
        evento = ec.getEvento();
        categoria = ec.getCategoria();
        return this;
    }
}
