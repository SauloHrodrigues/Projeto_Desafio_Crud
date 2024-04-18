package com.treinamentodb.Projeto_DesafioCrud.dto;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PessoaResponderDto {
    private Long id;
    private String nome;
    private String nascimento;
    private String CPF;
    private List<Endereco> enderecos;

    public PessoaResponderDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.nascimento = pessoa.getNascimento();
        this.CPF = pessoa.getCPF();
        this.enderecos = pessoa.getEnderecos();
    }
}
