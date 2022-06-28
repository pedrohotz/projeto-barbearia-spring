package com.example.barbearia.repository;

import com.example.barbearia.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDAO extends JpaRepository <Cliente, String>  {
    public Cliente findById(Integer id);

    @Query(value = "select a from Cliente a where a.idade >= 18")
    public List <Cliente> listarMaiores();
}
