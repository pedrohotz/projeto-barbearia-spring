package com.example.barbearia.repository;

import com.example.barbearia.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaREPO extends JpaRepository<Agenda, String> {
    public Agenda findById(Integer id);
}
