package com.example.barbearia.services;

import com.example.barbearia.dto.AgendamentoDTO;
import com.example.barbearia.models.Agenda;
import com.example.barbearia.models.Cliente;
import com.example.barbearia.models.Equipe;
import com.example.barbearia.models.TipoCorte;
import com.example.barbearia.repository.AgendaREPO;
import com.example.barbearia.repository.ClienteDAO;
import com.example.barbearia.repository.EquipeREPO;
import com.example.barbearia.repository.TipoREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;


@Service
public class AgendaService {
    @Autowired
    EquipeREPO equipeREPO;
    @Autowired
    ClienteDAO clienteREPO;

    @Autowired
    TipoREPO tipoRepo;
    @Autowired
    AgendaREPO agendaREPO;
    @Autowired
    ModelMapper modelMapper;

    public Agenda criar(AgendamentoDTO agenda){
        Agenda novaAgenda = modelMapper.map(agenda, Agenda.class);
        TipoCorte tipo = tipoRepo.findById(agenda.getTipoId());
        novaAgenda.setTipo(tipo);
        novaAgenda.setCliente(clienteREPO.findById(agenda.getClientId()));
        novaAgenda.setEquipe(equipeREPO.findById(agenda.getEquipeId()));
        novaAgenda.setData(agenda.getData());
        agendaREPO.save(novaAgenda);

        return novaAgenda;
    }

    public Agenda listarPorId(Integer id){
        return  agendaREPO.findById(id);
    }

    public List<Agenda> listarPorData(LocalDate data){
        List<Agenda> agendas = agendaREPO.findByData(data);
        if(agendas.isEmpty()){
            return  null;
        }
        return agendas;
    }
}
