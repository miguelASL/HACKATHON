package com.hackathon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SkinService {
    public List<Usuario> readSkinsFromJsonFile(String jsonFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Usuario> skins = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Usuario>>() {});
            return skins;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
