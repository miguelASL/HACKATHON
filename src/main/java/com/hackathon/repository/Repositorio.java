package com.hackathon.repository;

import com.hackathon.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface Repositorio extends JpaRepository<Usuario, Integer> {
}
