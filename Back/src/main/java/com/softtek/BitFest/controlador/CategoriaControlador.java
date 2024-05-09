package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Categoria;
import com.softtek.BitFest.servicio.CategoriaImpl;
import com.softtek.BitFest.servicio.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {

    @Autowired
    private ICategoriaServicio servicio;

    @GetMapping
    public List<Categoria> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.consultarTodos();
    }

    @GetMapping("/{id}")
    public Categoria obtenerId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @PostMapping
    public void crearCategoria(@RequestBody Categoria categoria) throws SQLException, ClassNotFoundException {
        servicio.crear(categoria);
    }

    @PutMapping
    public void actualizarCategoria(@RequestBody Categoria categoria) throws SQLException, ClassNotFoundException {
        servicio.modificar(categoria);
    }

    @DeleteMapping("/{id}")
    public void borrarCategoria(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }
}
