package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Imagen;
import com.softtek.BitFest.servicio.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
public class ImagenControlador {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public List<Imagen> getAllImagenes() {
        return imagenService.getAllImagenes();
    }

    @GetMapping("/{id}")
    public Imagen getImagenById(@PathVariable int id) {
        return imagenService.getImagenById(id);
    }

    @PostMapping
    public Imagen createImagen(@RequestBody Imagen imagen) {
        return imagenService.createImagen(imagen);
    }

    @PutMapping("/{id}")
    public Imagen updateImagen(@PathVariable int id, @RequestBody Imagen imagen) {
        return imagenService.updateImagen(id, imagen);
    }

    @DeleteMapping("/{id}")
    public void deleteImagen(@PathVariable int id) {
        imagenService.deleteImagen(id);
    }
}
