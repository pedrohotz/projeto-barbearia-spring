package com.example.barbearia.resources;

import com.example.barbearia.dto.ClienteDTO;
import com.example.barbearia.models.Cliente;
import com.example.barbearia.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cliente")
public class ClienteResource {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastro(@RequestBody ClienteDTO cadastroCliente){
            return ResponseEntity.ok(clienteService.cadastro(cadastroCliente));
    }

}
