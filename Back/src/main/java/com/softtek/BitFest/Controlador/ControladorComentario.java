package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorComentario {
    @Autowired
    private IComentarioServicio Comentarioservicio;

    @GetMapping
    public ResponseEntity<List<Comentario>> listarTodosLosComentarios() {
        return new ResponseEntity<>(Comentarioservicio.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable int id) {
        if(Comentarioservicio.consultarUno(id) != null) {
            return ResponseEntity.ok(Comentarioservicio.consultarUno(id));
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Comentario con ID " + id + " no encontrado");
        }
    }

    @GetMapping("/evento/{idEvento}")
    public ResponseEntity<List<Comentario>> findByEvento_IdEvento(@PathVariable int idEvento) {
        return new ResponseEntity<>(Comentarioservicio.findByEvento_IdEvento(idEvento), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(Comentarioservicio.crear(comentario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Comentario> actualizarComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(Comentarioservicio.crear(comentario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable int id){
        if(Comentarioservicio.consultarUno(id) != null) {
            Comentarioservicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Comentario con ID " + id + " no encontrado");
        }
    }
}