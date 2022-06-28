package com.example.barbearia.resources;

import com.example.barbearia.dto.AgendamentoDTO;
import com.example.barbearia.models.Agenda;
import com.example.barbearia.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/agenda")
public class AgendamentoResource {

    @Autowired
    AgendaService agendaService;

    @PostMapping("/agendar")
    public ResponseEntity<Agenda> agendamento(@RequestBody AgendamentoDTO agenda){
            try{
               Agenda nova = agendaService.criar(agenda);
               return ResponseEntity.status(201).body(nova);
            }
            catch (Exception ex){
                return ResponseEntity.badRequest().build();
            }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Agenda> listarAgendas(@PathVariable Integer id){
            Agenda agenda = agendaService.listarPorId(id);
            return  ResponseEntity.ok().body(agenda);
    }
}
