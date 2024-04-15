package com.treinamentodb.Projeto_DesafioCrud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String Estado;
    @ManyToOne
    Pessoa pessoa;

    private Endereco(){}
}
