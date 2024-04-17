package com.treinamentodb.Projeto_DesafioCrud.service.interfaces;

import com.treinamentodb.Projeto_DesafioCrud.DTO.request.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.DTO.response.EnderecoResponseDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;

public interface EnderecoInterface {

    public EnderecoResponseDto cadatrarNovoEndereco(EnderecoRequestDto novoEndereco);

    Endereco cadatrarNovoEndereco(Endereco novoEndereco);

    public EnderecoResponseDto alterarEndereco(Long id, EnderecoRequestDto novoEndereco);
    public boolean deletarNovoEndereco(Long id, EnderecoRequestDto novoEndereco);
}
