package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.dto.ComentarioDTO;
import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorComentario {
    @Autowired
    private IComentarioServicio comentarioServicio;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listarTodosLosComentarios() {
        List<Comentario> comentarios = comentarioServicio.consultarTodos();
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        for (Comentario comentario : comentarios) {
            ComentarioDTO dto = ComentarioDTO.fromEntity(comentario);
            comentariosDTO.add(dto);
        }
        return new ResponseEntity<>(comentariosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentarioPorId(@PathVariable int id) {
        Comentario comentario = comentarioServicio.consultarUno(id);
        if (comentario == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Comentario con ID " + id + " no encontrado");
        }
        return new ResponseEntity<>(ComentarioDTO.fromEntity(comentario), HttpStatus.OK);
    }

    @GetMapping("/evento/{idEvento}")
    public ResponseEntity<List<ComentarioDTO>> findByEvento_IdEvento(@PathVariable int idEvento) {
        List<Comentario> comentarios = comentarioServicio.findByEvento_IdEvento(idEvento);
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        for (Comentario comentario : comentarios) {
            ComentarioDTO dto = ComentarioDTO.fromEntity(comentario);
            comentariosDTO.add(dto);
        }
        return new ResponseEntity<>(comentariosDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioDTO.castComentario();
        comentario = comentarioServicio.crear(comentario);
        return new ResponseEntity<>(ComentarioDTO.fromEntity(comentario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ComentarioDTO> actualizarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioServicio.consultarUno(comentarioDTO.getIdComentario());
        if (comentario == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Comentario no encontrado " + comentarioDTO.getIdComentario());
        }
        comentario = comentarioServicio.modificar(comentarioDTO.castComentario());
        return new ResponseEntity<>(ComentarioDTO.fromEntity(comentario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable int id) {
        Comentario comentario = comentarioServicio.consultarUno(id);
        if (comentario != null) {
            comentarioServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Comentario con ID " + id + " no encontrado");
        }
    }
}
