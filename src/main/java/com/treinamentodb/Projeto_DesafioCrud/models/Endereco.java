package com.treinamentodb.Projeto_DesafioCrud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@Embeddable // classe embutida
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String Estado;


}
