package com.treinamentodb.Projeto_DesafioCrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequestDto {

    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String estado;
}
