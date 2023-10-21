package com.hackathon.controllers;

import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skins")
public class UsuarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private Repositorio repositorio;

    @GetMapping("/available")
    public ResponseEntity<List<Usuario>> getAvailableSkins() {
        List<Usuario> availableSkins = repositorio.findAll();
        return ResponseEntity.ok(availableSkins);
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buySkin(@RequestBody Usuario skin) {
        Usuario savedSkin = repositorio.save(skin);
        return ResponseEntity.status(HttpStatus.CREATED).body("Skin comprada con éxito");
    }

    @GetMapping("/myskins")
    public ResponseEntity<List<Usuario>> getMySkins() {
        List<Usuario> mySkins = repositorio.findAll();
        return ResponseEntity.ok(mySkins);
    }

    @PutMapping("/color/{id}")
    public ResponseEntity<String> changeSkinColor(@PathVariable Integer id, @RequestParam String newColor) {
        Optional<Usuario> optionalSkin = repositorio.findById(id);
        if (optionalSkin.isPresent()) {
            Usuario skin = optionalSkin.get();
            skin.setColor(newColor);
            repositorio.save(skin);
            return ResponseEntity.ok("Color de skin actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkin(@PathVariable Integer id) {
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            repositorio.delete(skin.get());
            return ResponseEntity.ok("Skin eliminada con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSkinById(@PathVariable Integer id) {
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            return ResponseEntity.ok(skin);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }
}