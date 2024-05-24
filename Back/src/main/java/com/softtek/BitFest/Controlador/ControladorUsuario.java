package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorUsuario {
    @Autowired
    private IUsuarioServicio servicio;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodos() {
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerId(@PathVariable int id) {
        if(servicio.consultarUno(id)!= null) {
            return ResponseEntity.ok(servicio.consultarUno(id));
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Usuario con id " + id +" no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(servicio.crear(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario( @RequestBody Usuario usuario) {
        return new ResponseEntity<>(servicio.modificar(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable("id") int id) {
        if(servicio.consultarUno(id)!=null) {
            servicio.eliminar(id);
<<<<<<< HEAD
        return ResponseEntity.noContent().build();
=======
            return ResponseEntity.noContent().build();
>>>>>>> 599bb1feb194207a9ade9335a322d89a14f0f7cf
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Usuario con id  " + id +" no encontrado");
        }

    }

    @GetMapping("/pornombreUsuario")
    public ResponseEntity<Optional<Usuario>> findByNombreUsuario (@RequestParam(name="nombreUsuario") String nombreUsuario){
        return new ResponseEntity<>(servicio.findByNombreUsuario(nombreUsuario), HttpStatus.OK);
    }

    @GetMapping("/poremail")
    public ResponseEntity<Optional<Usuario>> findByEmail (@RequestParam(name="email") String email){
        return new ResponseEntity<>(servicio.findByEmail(email), HttpStatus.OK);
    }

}