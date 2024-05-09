package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponseDto;

import java.util.List;

public interface PessoaService {

    PessoaResponseDto gravar(PessoaRequestDto request);

    PessoaResponseDto alterar(Long id, PessoaRequestDto pessoaAlterada);

    List<PessoaResponseDto> listarPessoasCadastradas();

    boolean apagarPessoa(Long id);
}
