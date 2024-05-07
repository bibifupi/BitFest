package com.softtek.BitFest.controlador;

import com.softtek.BitFest.modelo.Like;
import com.softtek.BitFest.servicio.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeControlador {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }

    @GetMapping("/{id}")
    public Like getLikeById(@PathVariable int id) {
        return likeService.getLikeById(id);
    }

    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeService.createLike(like);
    }

    @PutMapping("/{id}")
    public Like updateLike(@PathVariable int id, @RequestBody Like like) {
        return likeService.updateLike(id, like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable int id) {
        likeService.deleteLike(id);
    }
}
