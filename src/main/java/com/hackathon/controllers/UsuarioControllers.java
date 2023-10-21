package com.hackathon.controllers;

import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/skins")
public class UsuarioControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioControllers.class);
    @Autowired
    private Repositorio repositorio;

    @GetMapping("/available")
    public ResponseEntity<List<Usuario>> getAvailableSkins() {
        List<Usuario> availableSkins = repositorio.findAll();
        return new ResponseEntity<>(availableSkins, HttpStatus.OK);
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buySkin(@RequestBody Usuario skin) {
        Usuario savedSkin = repositorio.save(skin);
        return new ResponseEntity<>("Skin comprada con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/myskins")
    public ResponseEntity<List<Usuario>> getMySkins() {
        List<Usuario> mySkins = repositorio.findAll();
        return new ResponseEntity<>(mySkins, HttpStatus.OK);
    }

    @PutMapping("/skins/color/{id}")
    public ResponseEntity<?> changeSkinColor(@PathVariable Integer id, @RequestParam String newColor) {
        Optional<Usuario> optionalSkin = repositorio.findById(id);
        if (optionalSkin.isPresent()) {
            Usuario skin = optionalSkin.get();
            skin.setColor(newColor);
            repositorio.save(skin);
            return new ResponseEntity<>("Color de skin actualizado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skin no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkin(@PathVariable Integer id) {
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            repositorio.delete(skin);
            return new ResponseEntity<>("Skin eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skin no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getskin/{id}")
    public ResponseEntity<?> getSkinById(@PathVariable Integer id) {
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            return new ResponseEntity<>(skin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skin no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}