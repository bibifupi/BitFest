package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/organizadores")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorOrganizador {
    @Autowired
    private IOrganizadorServicio servicio;

    @GetMapping
    public List<Organizador> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.consultarTodos();
    }

    @GetMapping("/{id}")
    public Organizador obtenerId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @PostMapping
    public void insertarOrganizador(@RequestBody Organizador organizador) throws SQLException, ClassNotFoundException {
        servicio.crear(organizador);
    }

    @PutMapping
    public void actualizarOrganizador(@RequestBody Organizador organizador) throws SQLException, ClassNotFoundException {
        servicio.modificar(organizador);
    }

    @DeleteMapping("/{id}")
    public void borrarOrganizador(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }

}
