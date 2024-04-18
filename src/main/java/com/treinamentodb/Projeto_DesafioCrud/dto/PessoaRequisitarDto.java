package com.treinamentodb.Projeto_DesafioCrud.dto;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PessoaRequisitarDto {
        private String nome;
        private String nascimento;
        private String CPF;
        private Endereco enderecos;

}
