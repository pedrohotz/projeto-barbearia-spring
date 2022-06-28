package com.example.barbearia.repository;

import com.example.barbearia.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends JpaRepository <Cliente, String>  {
    public Cliente findById(Integer id);
}
