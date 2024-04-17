package com.treinamentodb.Projeto_DesafioCrud.DTO.request;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import lombok.Data;

@Data
//@Embeddable // classe embutida

public class EnderecoRequestDto {

    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String estado;

    public EnderecoRequestDto(Endereco endereco){
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.estado = endereco.getEstado();
    }
}
