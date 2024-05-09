package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.servicio.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoControlador {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public Evento getEventoById(@PathVariable int id) {
        return eventoService.getEventoById(id);
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.createEvento(evento);
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable int id, @RequestBody Evento evento) {
        return eventoService.updateEvento(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable int id) {
        eventoService.deleteEvento(id);
    }
}
