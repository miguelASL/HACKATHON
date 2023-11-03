package com.hackathon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SkinService {

    @Autowired
    private Repositorio repositorio;

    private static final Logger LOGGER = LoggerFactory.getLogger(SkinService.class);

    public List<Usuario> obtenerSkinsDisponibles(String s) {
        return repositorio.findAll();
    }

    public Usuario comprarSkin(Usuario skin) {
        return repositorio.save(skin);
    }

    public List<Usuario> obtenerSkinsDelUsuario() {
        return repositorio.findAll();
    }

    public String cambiarColorSkin(Integer id, String newColor) {
        Optional<Usuario> optionalSkin = repositorio.findById(id);
        if (optionalSkin.isPresent()) {
            Usuario skin = optionalSkin.get();
            skin.setColor(newColor);
            repositorio.save(skin);
            return "Color de skin actualizado con éxito";
        } else {
            return "Skin no encontrada";
        }
    }

    public String eliminarSkin(Integer id) {
        Optional<Usuario> optionalSkin = repositorio.findById(id);
        if (optionalSkin.isPresent()) {
            repositorio.delete(optionalSkin.get());
            return "Skin eliminada con éxito";
        } else {
            return "Skin no encontrada";
        }
    }

    public Optional<Usuario> obtenerSkinPorId(Integer id) {
        return repositorio.findById(id);
    }

    public <Skin> List<Skin> readSkinsFromJsonFile(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Skin> skins = objectMapper.readValue(new File(fileName), new TypeReference<List<Skin>>() {});
            return skins;
        } catch (IOException e) {
            // Manejar errores, por ejemplo, registrar el error
            e.printStackTrace();
            return null;
        }
    }
}