package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PessoaInterface {

    public List<Pessoa> listarPessoas();

    public Pessoa buscarPessoaPorId(Long id);

    public Pessoa cadastrarNovaPessoa(Pessoa pessoa);

    public Pessoa cadastrarNovoEnderco(Long id, Endereco novoEndereco);

    public boolean exluirPessoaPorId(Long id);


}
