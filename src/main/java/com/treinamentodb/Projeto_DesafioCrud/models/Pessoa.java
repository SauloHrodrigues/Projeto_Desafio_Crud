package com.treinamentodb.Projeto_DesafioCrud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long id;
    private String nome;
    private String nascimento;
    private String CPF;
//    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pees_id")
    private List<Endereco> enderecos;

    public Pessoa(String nome, String nascimento, String CPF, List<Endereco> enderecos) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.enderecos = enderecos;
    }

    public Pessoa(){

    }
}
