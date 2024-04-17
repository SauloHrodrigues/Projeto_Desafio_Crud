package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import com.treinamentodb.Projeto_DesafioCrud.service.PessoaInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Pessoa findAll(@PathVariable Long id) {
        return pessoa.buscarPessoaPorId(id);
    }

    @PostMapping
    public Pessoa cadastrarNovaPessoa(@RequestBody Pessoa pessoa) {
        return this.pessoa.cadastrarNovaPessoa(pessoa);
    }
    @PatchMapping ("/edereco/{id}")
    public Pessoa cadastrarNovoEnderco(@PathVariable("id") Long id, @RequestBody Endereco novoEndereco) {
        return pessoa.cadastrarNovoEnderco(id,novoEndereco);
    }

    @DeleteMapping("/{id}")
    public boolean exluirPessoaPorId(@PathVariable("id") Long id){
        return pessoa.exluirPessoaPorId(id);
    }

}
