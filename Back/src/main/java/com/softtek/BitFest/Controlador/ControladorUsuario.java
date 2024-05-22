package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.modelo.Usuario;
import com.softtek.BitFest.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorUsuario {
    @Autowired
    private IUsuarioServicio servicio;

    @GetMapping
    public List<Usuario> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.consultarTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtenerId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @PostMapping
    public void insertarUsuario(@RequestBody Usuario usuario) throws SQLException, ClassNotFoundException {
        servicio.crear(usuario);
    }

    @PutMapping
    public void actualizarUsuario(@RequestBody Usuario usuario) throws SQLException, ClassNotFoundException {
        servicio.modificar(usuario);
    }

    @DeleteMapping("/{id}")
    public void borrarUsuario(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }

}
