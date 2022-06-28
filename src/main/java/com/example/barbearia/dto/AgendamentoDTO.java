package com.example.barbearia.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {

    private Integer clientId;

    private Integer tipoId;

    private String descricao;

    private Integer equipeId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendamento;

}
