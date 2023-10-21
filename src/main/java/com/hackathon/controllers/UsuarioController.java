package com.hackathon.controllers;

import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import com.hackathon.service.SkinService;
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
    @Autowired
    private SkinService skinService;

    @GetMapping("/available")
    public ResponseEntity<?> getAvailableSkins() {
        List<Usuario> availableSkins = repositorio.findAll();

        if (availableSkins.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay skin disponibles");
        } else {
            return ResponseEntity.ok(availableSkins.get(0));
        }
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

/*    @PutMapping("/color")
    public ResponseEntity<String> changeSkinColor(@RequestParam String newColor, Usuario usuario) {
        if (optionalSkin.isPresent()) {
            Usuario skin = optionalSkin.get();
            skin.setColor(newColor);
            repositorio.save(skin);
            return ResponseEntity.ok("Color de skin actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSkin(@PathVariable Integer id) {
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            repositorio.delete(skin.get());
            return ResponseEntity.ok("Skin eliminada con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    @GetMapping("/getskin/{id}")
    public ResponseEntity<?> getSkinById(@PathVariable Integer id) {
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            return ResponseEntity.ok(skin);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    @GetMapping("/loadSkins")
    public ResponseEntity<List<Usuario>> loadSkins() {
        List<Usuario> skins = skinService.readSkinsFromJsonFile("SkinService.java");
        if (skins != null) {
            return ResponseEntity.ok(skins);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}