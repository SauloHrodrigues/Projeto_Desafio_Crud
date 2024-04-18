package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.dto.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequisitarDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponderDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.service.interfaces.PessoaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private  PessoaInterface pessoa;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoa.listarPessoas();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return pessoa.buscarPessoaPorId(id);

    }

    @PostMapping
    public Pessoa cadastrarNovaPessoa(@RequestBody PessoaRequisitarDto pessoaRequisitarDtoo) {
        return pessoa.cadastrarNovaPessoa(pessoaRequisitarDtoo);
    }
    @PatchMapping ("/edereco/{id}")
    public PessoaResponderDto cadastrarNovoEnderco(@PathVariable("id") Long id, @RequestBody EnderecoRequestDto novoEndereco) {
        return pessoa.cadastrarNovoEnderco(id,novoEndereco);
    }

    @DeleteMapping("/{id}")
    public boolean exluirPessoaPorId(@PathVariable("id") Long id){
        return pessoa.exluirPessoaPorId(id);
    }
}