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
        return new ResponseEntity<>(Comentarioservicio.consultarUno(id), HttpStatus.OK);
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<Comentario>> findByEvento_IdEvento(@PathVariable int idEvento) {
        return new ResponseEntity<>(Comentarioservicio.findByEvento_IdEvento(idEvento), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(Comentarioservicio.crear(comentario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable("id") int id, @RequestBody Comentario comentario) {
        if(Comentarioservicio.consultarUno(id)==null) {
            return ResponseEntity.ok(Comentarioservicio.modificar(comentario));
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Organizador " + id +" no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable int id){
        if(Comentarioservicio.consultarUno(id) == null) {
            Comentarioservicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Evento con ID " + id + " no encontrado");
        }
    }
}
