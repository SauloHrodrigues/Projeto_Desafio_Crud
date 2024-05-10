package com.treinamentodb.Projeto_DesafioCrud.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long id;
    private String nome;
    private String nascimento;
    @Column(unique = true)
    private String cpf;
//    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pees_id")
    private List<Endereco> enderecos = new ArrayList<>();


}
