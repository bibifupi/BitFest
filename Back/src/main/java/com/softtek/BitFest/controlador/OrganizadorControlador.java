package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorControlador {

    @Autowired
    private IOrganizadorServicio organizadorServicio;

    @GetMapping
    public ResponseEntity<List<Organizador>> obtenerTodosLosOrganizadores() {
        return ResponseEntity.ok(organizadorServicio.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizador> obtenerOrganizadorPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(organizadorServicio.consultarUno(id));
    }

    @PostMapping
    public ResponseEntity<Organizador> crearOrganizador(@RequestBody Organizador organizador) {
        return ResponseEntity.ok(organizadorServicio.crear(organizador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizador> actualizarOrganizador(@PathVariable("id") int id, @RequestBody Organizador organizador) {
        return ResponseEntity.ok(organizadorServicio.modificar(organizador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrganizador(@PathVariable("id") int id) {
        organizadorServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
