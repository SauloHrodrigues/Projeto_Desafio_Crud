package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.dto.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequisitarDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponderDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;
//    CRUD -> create, read, update, delete
    @PostMapping
    public  void salvarNovaPessoa(@RequestBody PessoaRequisitarDto dto ){
        service.gravar(dto);
    }

//     Read
    @GetMapping
    public List<PessoaResponderDto> listarPessoasCadastradas(){
        return service.listarPessoasCadastradas();
    }

    @PutMapping("/{id}")
    public void alterarPessoa(@PathVariable("id") Long id, @RequestBody PessoaRequisitarDto pessoaAlterada){
        service.alterar(id,pessoaAlterada);
    }
    @DeleteMapping("/{id}")
    public boolean deletarPessoa(@PathVariable("id") Long id){
        return service.apagarPessoa(id);
    }

}