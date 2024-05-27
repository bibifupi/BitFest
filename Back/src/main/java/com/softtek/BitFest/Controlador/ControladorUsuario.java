package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.dto.UsuarioPerfilDTO;
import com.softtek.BitFest.dto.UsuarioRegistroDTO;
import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.servicio.IUsuarioServicio;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioPerfilDTO> obtenerId(@PathVariable (name="id") Integer id) {
        Usuario u1 = servicio.consultarUno(id);
        if (u1 != null) {
            return new ResponseEntity<>((new UsuarioPerfilDTO()).castUsuarioPerfilDTO(u1), HttpStatus.OK);
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Usuario con id " + id + " no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioRegistroDTO> insertarUsuario(@Valid @RequestBody UsuarioRegistroDTO u) {
        Usuario u1 = u.castUsuario();
        u1 = servicio.crear(u1);
        return new ResponseEntity<>(u.castUsuarioRegistroDTO(u1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UsuarioPerfilDTO> actualizarUsuario( @Valid @RequestBody UsuarioPerfilDTO u) {
        Usuario u1 = servicio.consultarUno(u.getIdUsuario());
        if (u1 != null) {
            u1 = servicio.modificar(u.castUsuario());
            return new ResponseEntity<>(u.castUsuarioPerfilDTO(u1), HttpStatus.OK);
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Usuario no encontrado " + u.getIdUsuario());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable(name = "id") Integer id) {

        Usuario u1 = servicio.consultarUno(id);
        if (u1 != null) {
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Usuario con id " + id + " no encontrado");
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