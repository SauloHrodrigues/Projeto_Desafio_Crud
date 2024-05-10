package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponseDto;
import com.treinamentodb.Projeto_DesafioCrud.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    private final PessoaService service;

    @PostMapping
    public PessoaResponseDto salvarNovaPessoa(@RequestBody PessoaRequestDto dto ){
        return service.gravar(dto);
    }

    @GetMapping
    public List<PessoaResponseDto> listarPessoasCadastradas(){
        return service.listarPessoasCadastradas();
    }

    @PutMapping("/{id}")
    public PessoaResponseDto alterarPessoa(@PathVariable("id") Long id, @RequestBody PessoaRequestDto pessoaAlterada){
        return service.alterar(id,pessoaAlterada);
    }

    @DeleteMapping("/{id}")
    public boolean deletarPessoa(@PathVariable("id") Long id){
        return service.apagarPessoa(id);
    }
}