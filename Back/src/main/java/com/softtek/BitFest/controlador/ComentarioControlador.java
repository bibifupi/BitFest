package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Comentario;
import com.softtek.BitFest.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioControlador {

    @Autowired
    private IComentarioServicio servicio;

    @GetMapping
    public List<Comentario> listarTodosLosComentarios() throws SQLException, ClassNotFoundException {
        return servicio.consultarTodos();
    }

    @GetMapping("/{id}")
    public Comentario obtenerComentarioPorId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @GetMapping("/evento/{eventoId}")
    public List<Comentario> listarComentariosPorEventoId(@PathVariable int eventoId) throws SQLException, ClassNotFoundException {
        return servicio.findByEventoId(eventoId);
    }

    @PostMapping
    public void crearComentario(@RequestBody Comentario comentario) throws SQLException, ClassNotFoundException {
        servicio.crear(comentario);
    }

    @PutMapping
    public void actualizarComentario(@RequestBody Comentario comentario) throws SQLException, ClassNotFoundException {
        servicio.modificar(comentario);
    }

    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }
}
