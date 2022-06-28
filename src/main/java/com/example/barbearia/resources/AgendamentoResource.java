package com.example.barbearia.resources;

import com.example.barbearia.dto.AgendamentoDTO;
import com.example.barbearia.models.Agenda;
import com.example.barbearia.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @GetMapping("/listar-data/{data}")
    public ResponseEntity<List<Agenda>>listarPorData(@PathVariable String data){
        try {
            LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            List<Agenda> response = agendaService.listarPorData(date);

            if(response.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            else{
                return  ResponseEntity.ok().body(response);
            }
        }
        catch (Exception ex){
            return  ResponseEntity.badRequest().build();
        }
    }
}
