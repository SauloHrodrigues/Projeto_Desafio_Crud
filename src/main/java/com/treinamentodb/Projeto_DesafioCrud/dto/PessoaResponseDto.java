package com.treinamentodb.Projeto_DesafioCrud.dto;

import com.treinamentodb.Projeto_DesafioCrud.core.entities.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.core.entities.Pessoa;

import java.util.List;

public record PessoaResponseDto(
    Long id,
    String nome,
    String nascimento,
    String cpf,
    List<Endereco> enderecos

) {

    public PessoaResponseDto(Pessoa pessoa) {
        this(pessoa.getId(),
        pessoa.getNome(),
        pessoa.getNascimento(),
        pessoa.getCpf(),
        pessoa.getEnderecos());
    }
}
