package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Imagen;
import com.softtek.BitFest.servicio.IImagenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
public class ImagenControlador {

    @Autowired
    private IImagenServicio imagenService;

    @GetMapping
    public List<Imagen> getAllImagenes() {
        return imagenService.consultarTodos();
    }

    @GetMapping("/{id}")
    public Imagen getImagenById(@PathVariable int id) {
        return imagenService.consultarUno(id);
    }

    @PostMapping
    public Imagen createImagen(@RequestBody Imagen imagen) {
        return imagenService.crear(imagen);
    }

    @PutMapping("/{id}")
    public Imagen updateImagen(@PathVariable int id, @RequestBody Imagen imagen) {
        return imagenService.modificar(imagen);
    }

    @DeleteMapping("/{id}")
    public void deleteImagen(@PathVariable int id) {
        imagenService.eliminar(id);
    }
}
