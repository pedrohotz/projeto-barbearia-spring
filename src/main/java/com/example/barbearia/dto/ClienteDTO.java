package com.example.barbearia.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClienteDTO {
    @NotNull
    private String nome;
    private String telefone;
    private int idade;
}
