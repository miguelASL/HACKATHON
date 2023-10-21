package com.hackathon.service;

import com.hackathon.model.Usuario;
import com.hackathon.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SkinService {

    @Autowired
    private Repositorio repositorio;

    public List<Usuario> obtenerSkinsDisponibles() {
        // Lógica para obtener todas las skins disponibles desde la base de datos
        return repositorio.findAll();
    }

    public Usuario comprarSkin(Usuario skin) {
        // Lógica para validar y guardar la skin comprada en la base de datos
        return repositorio.save(skin);
    }

    public List<Usuario> obtenerSkinsDelUsuario() {
        // Lógica para obtener las skins compradas por el usuario actual (puedes agregar la lógica de autenticación aquí)
        return repositorio.findAll(); // Puedes ajustar esta lógica según tus necesidades
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

    public List<Usuario> readSkinsFromJsonFile(String fileName) {
        // Lógica para leer skins desde un archivo JSON (puedes implementar esta funcionalidad)
        return null;
    }
}
