package com.example.barbearia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Equipes")
@EqualsAndHashCode(callSuper = true)
public class Equipe extends Base {
    private String titulo;

    @OneToMany()
    private List<Agenda> agendas;
}
