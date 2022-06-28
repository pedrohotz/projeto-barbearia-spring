package com.example.barbearia.repository;

import com.example.barbearia.models.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeREPO extends JpaRepository<Equipe, String> {
    public Equipe findById(Integer id);
}
