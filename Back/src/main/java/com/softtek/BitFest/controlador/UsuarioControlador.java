package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        return ResponseEntity.ok(usuarioServicio.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(usuarioServicio.consultarUno(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioServicio.crear(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioServicio.modificar(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") int id) {
        usuarioServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
