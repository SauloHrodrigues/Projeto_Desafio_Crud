package com.treinamentodb.Projeto_DesafioCrud.dto;

import lombok.Data;

@Data
public class EnderecoRequestDto {

    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String estado;


}
