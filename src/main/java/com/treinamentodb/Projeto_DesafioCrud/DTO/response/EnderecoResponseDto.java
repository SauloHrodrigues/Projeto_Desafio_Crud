package com.treinamentodb.Projeto_DesafioCrud.DTO.response;

import com.treinamentodb.Projeto_DesafioCrud.DTO.request.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
//@Embeddable // classe embutida

public class EnderecoResponseDto {

    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String estado;


    public EnderecoResponseDto(Endereco endereco){
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.estado = endereco.getEstado();
    }
}
