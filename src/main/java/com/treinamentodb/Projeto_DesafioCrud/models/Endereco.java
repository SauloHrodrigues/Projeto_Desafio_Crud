package com.treinamentodb.Projeto_DesafioCrud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.treinamentodb.Projeto_DesafioCrud.DTO.request.EnderecoRequestDto;
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
    private String estado;

    public Endereco(EnderecoRequestDto novoEndereco) {
        this.rua = novoEndereco.getRua();
        this.numero = novoEndereco.getNumero();
        this.cidade = novoEndereco.getCidade();
        this.cep = novoEndereco.getCep();
        this.estado = novoEndereco.getEstado();
    }

    public Endereco() {
    }
}
