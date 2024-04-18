package com.treinamentodb.Projeto_DesafioCrud.models;


import com.treinamentodb.Projeto_DesafioCrud.dto.EnderecoRequestDto;
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

    public Endereco(String rua, String numero, String cidade, String cep, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }  public Endereco(EnderecoRequestDto enderecoRequestDto) {
        this.rua = enderecoRequestDto.getRua();
        this.numero = enderecoRequestDto.getNumero();
        this.cidade = enderecoRequestDto.getCidade();
        this.cep = enderecoRequestDto.getCep();
        this.estado = enderecoRequestDto.getEstado();
    }

    public Endereco(){

    }
}
