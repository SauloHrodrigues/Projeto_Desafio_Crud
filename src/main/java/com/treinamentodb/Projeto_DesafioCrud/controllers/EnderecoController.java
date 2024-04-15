package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.EnderecoRepository;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository endercoRepository;


    @GetMapping
    public List<Endereco> listarEndereco() {
        return endercoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Endereco findAll(@PathVariable Long id) {
        return endercoRepository.findById(id).get();
    }

    @PostMapping
    public Endereco cadastrarNovoEndereco(@RequestBody Endereco endereco) {
        return endercoRepository.save(endereco);
    }
}
