package com.treinamentodb.Projeto_DesafioCrud.DTO.response;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class PessoaResponseDto {

    private Long id;
    private String nome;
    private String nascimento;
    private String CPF;

    private List<Endereco> enderecos;

    public PessoaResponseDto(PessoaResponseDto pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.nascimento = pessoa.getNascimento();
        this.CPF = pessoa.getCPF();
        this.enderecos = pessoa.getEnderecos();
    }

}
