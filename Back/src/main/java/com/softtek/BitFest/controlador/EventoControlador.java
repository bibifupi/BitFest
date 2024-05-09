package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.servicio.IEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoControlador {

    @Autowired
    private IEventoServicio eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.consultarTodos();
    }

    @GetMapping("/{id}")
    public Evento getEventoById(@PathVariable int id) {
        return eventoService.consultarUno(id);
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.crear(evento);
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable int id, @RequestBody Evento evento) {
        return eventoService.modificar(evento);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable int id) {
        eventoService.eliminar(id);
    }
}
