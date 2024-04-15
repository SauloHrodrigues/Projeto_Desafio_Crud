package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;


    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findAll(@PathVariable Long id) {
        return pessoaRepository.findById(id).get();
    }

    @PostMapping
    public Pessoa cadastrarNovaPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
