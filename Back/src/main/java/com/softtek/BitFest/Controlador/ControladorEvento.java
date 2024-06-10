package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.dto.EventoDTO;
import com.softtek.BitFest.dto.EventoDetalleDTO;
import com.softtek.BitFest.dto.EventoInicioDTO;
import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.servicio.IEventoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/eventos")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorEvento {
    @Autowired
    private IEventoServicio eventoServicio;

    @GetMapping
    public ResponseEntity<List<EventoInicioDTO>> obtenerTodosEventos() {
        List<Evento> eventosBBDD = eventoServicio.consultarTodos();
        List<EventoInicioDTO> eventosDTO = new ArrayList<>();
        for (Evento elemento : eventosBBDD) {
            EventoInicioDTO eDTO = new EventoInicioDTO();
            eventosDTO.add(eDTO.castEventoDTO(elemento));
        }
        return new ResponseEntity<>(eventosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDetalleDTO> obtenerEventoId(@PathVariable(name = "id") Integer id) {
        Evento e1 = eventoServicio.consultarUno(id);
        if (e1 != null) {
            return new ResponseEntity<>((new EventoDetalleDTO()).castEventoDetalleDTO(e1), HttpStatus.OK);
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Evento con id " + id + " no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<EventoDTO> insertarEvento(@Valid @RequestBody EventoDTO e) {
        Evento e1 = e.castEvento();
        e1 = eventoServicio.crear(e1);
        return new ResponseEntity<>(e.castEventoDTO(e1), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<EventoDTO> actualizarEvento(@Valid @RequestBody EventoDTO e) {
        Evento e1 = eventoServicio.consultarUno(e.getIdEvento());
        if (e1 != null) {
            e1 = eventoServicio.modificar(e.castEvento());
            return new ResponseEntity<>(e.castEventoDTO(e1), HttpStatus.OK);
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Evento no encontrado " + e.getIdEvento());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEvento(@PathVariable(name = "id") Integer id) {
        Evento e1 = eventoServicio.consultarUno(id);
        if (e1 != null) {
            eventoServicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Evento con id " + id + " no encontrado");
        }
    }


    @GetMapping("/portitulo")
    public ResponseEntity<List<EventoInicioDTO>> findByTituloLike(@RequestParam(name = "titulo") String titulo) {
        List<Evento> eventosBBDD = eventoServicio.findByTituloLike(titulo);
        List<EventoInicioDTO> eventosDTO = new ArrayList<>();
        for (Evento elemento : eventosBBDD) {
            EventoInicioDTO eDTO = new EventoInicioDTO();
            eventosDTO.add(eDTO.castEventoDTO(elemento));
        }
        return new ResponseEntity<>(eventosDTO, HttpStatus.OK);
    }
    @GetMapping("/7primeros")
    public ResponseEntity<List<EventoInicioDTO>> findFirst7ByFechaRealizacionGreaterThanEqual() {
        List<Evento> eventosBBDD = eventoServicio.findFirst7ByFechaRealizacionGreaterThanEqual();
        List<EventoInicioDTO> eventosDTO = new ArrayList<>();
        for (Evento elemento : eventosBBDD) {
            EventoInicioDTO eDTO = new EventoInicioDTO();
            eventosDTO.add(eDTO.castEventoDTO(elemento));
        }
        return new ResponseEntity<>(eventosDTO, HttpStatus.OK);

    }

    @GetMapping("/FechaRealizacion")
    public ResponseEntity<List<EventoInicioDTO>> findAllByOrderByFechaRealizacion() {
        List<Evento> eventosBBDD = eventoServicio.findAllByOrderByFechaRealizacion();
        List<EventoInicioDTO> eventosDTO = new ArrayList<>();
        for (Evento elemento : eventosBBDD) {
            EventoInicioDTO eDTO = new EventoInicioDTO();
            eventosDTO.add(eDTO.castEventoDTO(elemento));
        }
        return new ResponseEntity<>(eventosDTO, HttpStatus.OK);
    }

    @GetMapping("/eventopororganizador")
    public ResponseEntity<List<EventoInicioDTO>> findByOrganizador_NombreOrderByOrganizador_Nombre(@RequestParam String Busqueda) {
        List<Evento> eventosBBDD = eventoServicio.findByOrganizador_NombreOrderByOrganizador_Nombre(Busqueda);
        List<EventoInicioDTO> eventosDTO = new ArrayList<>();
        for (Evento elemento : eventosBBDD) {
            EventoInicioDTO eDTO = new EventoInicioDTO();
            eventosDTO.add(eDTO.castEventoDTO(elemento));
        }
        return new ResponseEntity<>(eventosDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EventoInicioDTO>> buscarEventos(@RequestParam String query) {
        List<Evento> eventosBBDD = eventoServicio.buscarEventos(query);
        List<EventoInicioDTO> eventosDTO = new ArrayList<>();
        for (Evento evento : eventosBBDD) {
            EventoInicioDTO eDTO = new EventoInicioDTO();
            eventosDTO.add(eDTO.castEventoDTO(evento));
        }
        return new ResponseEntity<>(eventosDTO, HttpStatus.OK);
    }


}
