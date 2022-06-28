package com.example.barbearia.services;

import com.example.barbearia.dto.ClienteDTO;
import com.example.barbearia.models.Cliente;
import com.example.barbearia.repository.ClienteDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteDAO clienteRepo;

    @Autowired
    ModelMapper modelMapper;

    public Cliente cadastro(ClienteDTO cliente) {
        Cliente c = modelMapper.map(cliente, Cliente.class);
        return  clienteRepo.save(c);
    }

    public List <Cliente> listarMaiores(){
        List clientes = clienteRepo.listarMaiores();

        if(clientes.isEmpty()){
            return null;
        }
        else{
            return clientes;
        }
    }
}
