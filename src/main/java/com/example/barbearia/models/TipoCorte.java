package com.example.barbearia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TipoCorte")
@EqualsAndHashCode(callSuper = true)
public class TipoCorte extends Base {
    @Column
    private String nome;
    @Column
    private Double preco;

    @OneToMany()
    private List<Agenda> agendas;
}
