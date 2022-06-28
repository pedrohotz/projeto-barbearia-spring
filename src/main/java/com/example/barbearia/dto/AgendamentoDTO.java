package com.example.barbearia.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {

    @NotNull
    private Integer clientId;
    @NotNull
    private Integer tipoId;
    @NotNull
    private String descricao;
    @NotNull
    private Integer equipeId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

}
