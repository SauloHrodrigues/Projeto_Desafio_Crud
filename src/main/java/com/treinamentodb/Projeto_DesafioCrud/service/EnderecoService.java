package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.DTO.request.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.DTO.response.EnderecoResponseDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.repositories.EnderecoRepository;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import com.treinamentodb.Projeto_DesafioCrud.service.interfaces.EnderecoInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoService implements EnderecoInterface {

    @Autowired
    private EnderecoRepository endercoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public EnderecoResponseDto cadatrarNovoEndereco(EnderecoRequestDto novoEndereco) {
        Endereco endereco = new Endereco(novoEndereco);
        EnderecoResponseDto enderecoResponseDto = endercoRepository.save(endereco);
    }

    @Override
    public Endereco cadatrarNovoEndereco(Endereco novoEndereco) {
        return null;
    }

    @Override
    public EnderecoResponseDto alterarEndereco(Long id, EnderecoRequestDto novoEndereco) {
        return null;
    }

    @Override
    public boolean deletarNovoEndereco(Long id, EnderecoRequestDto novoEndereco) {
        return false;
    }
}
