package com.example.barbearia.resources;

import com.example.barbearia.dto.ClienteDTO;
import com.example.barbearia.models.Cliente;
import com.example.barbearia.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cliente")
public class ClienteResource {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastro(@RequestBody ClienteDTO cadastroCliente){
            return ResponseEntity.ok(clienteService.cadastro(cadastroCliente));
    }

    @GetMapping("/listar-maiores")
    public ResponseEntity <List<Cliente>> listarMaiores(){
        List clientes = clienteService.listarMaiores();

        if(clientes == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(clientes);
        }
    }
}
