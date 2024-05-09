package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.modelo.EventoCategoria;
import com.softtek.BitFest.servicio.IEventoCategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/eventoCategorias")
public class EventoCategoriaControlador {

    @Autowired
    private IEventoCategoriaServicio servicio;

    @GetMapping
    public List<EventoCategoria> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.consultarTodos();
    }
    @GetMapping("/{id}")
    public EventoCategoria obtenerId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @PostMapping
    public void crearEventoCategoria(@RequestBody EventoCategoria eventoCategoria) throws SQLException, ClassNotFoundException {
        servicio.crear(eventoCategoria);
    }

    @PutMapping
    public void actualizarEventoCategoria(@RequestBody EventoCategoria eventoCategoria) throws SQLException, ClassNotFoundException {
        servicio.modificar(eventoCategoria);
    }

    @DeleteMapping("/id")
    public void borrarEventoCategoria(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }
}
