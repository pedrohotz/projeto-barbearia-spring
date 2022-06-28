package com.example.barbearia.repository;

import com.example.barbearia.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioREPO extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
