package com.example.barbearia.repository;

import com.example.barbearia.models.TipoCorte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoREPO extends JpaRepository<TipoCorte, String> {

    public TipoCorte findById(Integer id);
}
