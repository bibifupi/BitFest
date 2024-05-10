package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Like;
import com.softtek.BitFest.servicio.ILikeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeControlador {

    @Autowired
    private ILikeServicio likeService;

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.consultarTodos();
    }

    @GetMapping("/{id}")
    public Like getLikeById(@PathVariable int id) {
        return likeService.consultarUno(id);
    }

    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeService.crear(like);
    }

    @PutMapping("/{id}")
    public Like updateLike(@PathVariable int id, @RequestBody Like like) {
        return likeService.modificar(like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable int id) {
        likeService.eliminar(id);
    }
}
