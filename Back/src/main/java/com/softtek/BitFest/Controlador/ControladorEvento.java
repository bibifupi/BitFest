package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.modelo.Evento;
import com.softtek.BitFest.servicio.IEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorEvento {
    @Autowired
    private IEventoServicio servicio;

    @GetMapping
    public List<Evento> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.consultarTodos();
    }

    @GetMapping("/{id}")
    public Evento obtenerId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @PostMapping
    public void insertarEvento(@RequestBody Evento evento) throws SQLException, ClassNotFoundException {
        servicio.crear(evento);
    }

    @PutMapping
    public void actualizarEvento(@RequestBody Evento evento) throws SQLException, ClassNotFoundException {
        servicio.modificar(evento);
    }

    @DeleteMapping("/{id}")
    public void borrarEvento(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }

}
