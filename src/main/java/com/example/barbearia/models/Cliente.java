package com.example.barbearia.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clientes")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Base {
    @NotNull
    private String nome;
    private String telefone;
    private int idade;

    @OneToMany()
    private List<Agenda> agendas;

}
