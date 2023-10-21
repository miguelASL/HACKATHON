package com.hackathon.controllers;

import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/skins")
public class UsuarioControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioControllers.class);
    @Autowired
    private Repositorio repositorio;

    @GetMapping("/available")
    public ResponseEntity<String> getAvailableSkins() {
        LOGGER.info("Obteniendo la lista de las skins disponibles");
        List<Usuario> availableSkins = repositorio.findAll();

        if (availableSkins.isEmpty()) {
            LOGGER.info("No hay skins disponibles");
            return new ResponseEntity<>("No hay skins disponibles", HttpStatus.NOT_FOUND);
        } else {
            int numSkins = availableSkins.size();
            LOGGER.info("Número de skins disponibles: " + numSkins);
            return new ResponseEntity<>("Número de skins disponibles: " + numSkins, HttpStatus.OK);
        }
    }
}






