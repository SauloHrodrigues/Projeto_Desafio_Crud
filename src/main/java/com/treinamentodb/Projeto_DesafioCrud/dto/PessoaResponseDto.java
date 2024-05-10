package com.treinamentodb.Projeto_DesafioCrud.dto;

import com.treinamentodb.Projeto_DesafioCrud.core.entities.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.core.entities.Pessoa;
import lombok.Data;

import java.util.List;
@Data
public class PessoaResponseDto {
    private Long id;
    private String nome;
    private String nascimento;
    private String cpf;
    private List<Endereco> enderecos;
}
