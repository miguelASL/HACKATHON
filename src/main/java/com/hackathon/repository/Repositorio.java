package com.hackathon.repository;

import com.hackathon.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Repositorio extends JpaRepository<Usuario, Integer> {
    default Usuario save(Usuario usuario) {
        return null;
    }
    void save(Optional<Usuario> skin);
    void delete(Optional<Usuario> skin);
}
