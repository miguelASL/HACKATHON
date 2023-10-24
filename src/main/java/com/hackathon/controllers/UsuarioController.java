package com.hackathon.controllers;

import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import com.hackathon.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Skins", description = "Operaciones relacionadas con las skins")
@RequestMapping("/skins")
public class UsuarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private Repositorio repositorio;

    @Autowired
    private SkinService skinService;

    @GetMapping("/available")
    @ApiOperation("Obtener la lista de skins disponibles")
    public ResponseEntity<?> getAvailableSkins() {
        LOGGER.info("Solicitud para obtener la lista de skins disponibles");
        List<Usuario> availableSkins = repositorio.findAll();

        if (availableSkins.isEmpty()) {
            LOGGER.info("No hay skins disponibles");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay skin disponibles");
        } else {
            LOGGER.info("Se ha encontrado una skin disponible");
            return ResponseEntity.ok(availableSkins.get(0));
        }
    }

    @PostMapping("/buy")
    @ApiOperation("Comprar una skin")
    public ResponseEntity<String> buySkin(@RequestBody Usuario skin) {
        LOGGER.info("Solicitud para comprar una skin");
        Usuario savedSkin = repositorio.save(skin);
        return ResponseEntity.status(HttpStatus.CREATED).body("Skin comprada con éxito");
    }

    @GetMapping("/myskins")
    @ApiOperation("Obtener la lista de skins compradas")
    public ResponseEntity<List<Usuario>> getMySkins() {
        LOGGER.info("Solicitud para obtener la lista de skins compradas");
        List<Usuario> mySkins = repositorio.findAll();
        return ResponseEntity.ok(mySkins);
    }

    @PutMapping("/color/{id}")
    @ApiOperation("Cambiar el color de una skin comprada")
    public ResponseEntity<String> changeSkinColor(@PathVariable Integer id, @RequestParam String newColor) {
        LOGGER.info("Solicitud para cambiar el color de una skin comprada");
        Optional<Usuario> optionalSkin = repositorio.findById(id);
        if (optionalSkin.isPresent()) {
            Usuario skin = optionalSkin.get();
            skin.setColor(newColor);
            repositorio.save(skin);
            LOGGER.info("Color de skin actualizado con éxito");
            return ResponseEntity.ok("Color de skin actualizado con éxito");
        } else {
            LOGGER.info("Skin no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Eliminar una skin comprada")
    public ResponseEntity<String> deleteSkin(@PathVariable Integer id) {
        LOGGER.info("Solicitud para eliminar una skin comprada");
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            repositorio.delete(skin.get());
            LOGGER.info("Skin eliminada con éxito");
            return ResponseEntity.ok("Skin eliminada con éxito");
        } else {
            LOGGER.info("Skin no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    @GetMapping("/getskin/{id}")
    @ApiOperation("Obtener una skin comprada por id")
    public ResponseEntity<?> getSkinById(@PathVariable Integer id) {
        LOGGER.info("Solicitud para obtener una skin por ID");
        Optional<Usuario> skin = repositorio.findById(id);
        if (skin.isPresent()) {
            LOGGER.info("Se ha encontrado la skin por ID");
            return ResponseEntity.ok(skin);
        } else {
            LOGGER.info("Skin no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skin no encontrada");
        }
    }

    /*@GetMapping("/loadSkins")
    @ApiOperation("Cargar skins desde un archivo JSON")
    public ResponseEntity<List<Usuario>> loadSkins() {
        LOGGER.info("Solicitud para cargar skins desde un archivo JSON");
        List<Usuario> skins = skinService.readSkinsFromJsonFile("classpath:skins.json");
        if (skins != null) {
            LOGGER.info("Skins cargadas con éxito desde un archivo JSON");
            return ResponseEntity.ok(skins);
        } else {
            LOGGER.info("Error al cargar las skins desde un archivo JSON");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
}