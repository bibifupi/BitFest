package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.servicio.IEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorEvento {
    @Autowired
    private IEventoServicio eventoServicio;

    @GetMapping
    public ResponseEntity<List<Evento>> obtenerTodosEventos(){
        return new ResponseEntity<>(eventoServicio.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerEventoId(@PathVariable("id") int id)  {
        return new ResponseEntity<>(eventoServicio.consultarUno(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evento> insertarEvento(@RequestBody Evento evento) {
        return new ResponseEntity<>(eventoServicio.crear(evento), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable("id") int id, @RequestBody Evento evento) {
        if(eventoServicio.consultarUno(id)==null) {
            return ResponseEntity.ok(eventoServicio.modificar(evento));
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Organizador " + id +" no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarEvento(@PathVariable("id") int id)  {
        if(eventoServicio.consultarUno(id) == null) {
            eventoServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Evento con ID " + id + " no encontrado");
        }
    }


    @GetMapping("/portitulo")
    public ResponseEntity<List<Evento>> findByTituloLike(@RequestParam String titulo) {
        return new ResponseEntity<>(eventoServicio.consultarTodos(), HttpStatus.OK);
    }
    @GetMapping("/7primeros")
    public ResponseEntity<List<Evento>> findFirst7ByFechaRealizacion(@RequestParam LocalDate fechaRealizacion) {
        return new ResponseEntity<>(eventoServicio.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/FechaRealizacion")
    public ResponseEntity<List<Evento>> findAllByOrderByFechaRealizacion() {
        return new ResponseEntity<>(eventoServicio.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/eventopororganizador")
    public ResponseEntity<List<Evento>> findByOrganizador_NombreOrderByOrganizador_Nombre(@RequestParam String Busqueda) {
        return new ResponseEntity<>(eventoServicio.consultarTodos(), HttpStatus.OK);
    }
}
