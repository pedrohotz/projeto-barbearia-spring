package com.example.barbearia.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "Agenda")
@EqualsAndHashCode(callSuper = true)
public class Agenda extends Base{

    @ManyToOne()
    private TipoCorte tipo;

    @ManyToOne()
    private Cliente cliente;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @ManyToOne()
    private Equipe equipe;

    private String descricao;

}
