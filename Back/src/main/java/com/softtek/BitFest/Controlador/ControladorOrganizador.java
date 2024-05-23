package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/organizadores")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorOrganizador {
    @Autowired
    private IOrganizadorServicio servicio;

    @GetMapping
    public ResponseEntity<List<Organizador>> obtenerTodos() {
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizador> obtenerId(@PathVariable int id) {
        if(servicio.consultarUno(id)!=null) {
            return ResponseEntity.ok(servicio.consultarUno(id));
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Organizador con id " + id +" no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<Organizador> insertarOrganizador(@RequestBody Organizador organizador) {
        return new ResponseEntity<>(servicio.crear(organizador), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Organizador> actualizarOrganizador(@PathVariable("id") int id, @RequestBody Organizador organizador) {
        return new ResponseEntity<>(servicio.modificar(organizador), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarOrganizador(@PathVariable("id") int id) {
        if(servicio.consultarUno(id)!=null) {
            servicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Organizador con id  " + id +" no encontrado");
        }
    }

    @GetMapping("/porOrganizador")
    public ResponseEntity<List<Organizador>> findFirst7ByNombre(@RequestParam(name="nombre") String nombre){
        return new ResponseEntity<>(servicio.findFirst7ByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/porOrganizadorLike")
    public ResponseEntity<List<Organizador>> findByNombreLike(@RequestParam(name="nombre") String nombre){
        return new ResponseEntity<>(servicio.findByNombreLike(nombre), HttpStatus.OK);
    }

}
