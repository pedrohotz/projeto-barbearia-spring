package com.example.barbearia.repository;

import com.example.barbearia.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AgendaREPO extends JpaRepository<Agenda, String> {
    public Agenda findById(Integer id);

    public List<Agenda> findByData(LocalDate data);
}
