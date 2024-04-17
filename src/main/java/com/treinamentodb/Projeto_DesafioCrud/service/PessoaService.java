package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import com.treinamentodb.Projeto_DesafioCrud.service.interfaces.PessoaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements PessoaInterface {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorId(Long id) throws RuntimeException {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("No data!"));
    }


    public Pessoa cadastrarNovaPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa cadastrarNovoEnderco(Long id, Endereco novoEndereco) {
        Pessoa pessoaLocalizada = pessoaRepository.findById(id).orElse(null);
        pessoaLocalizada.getEnderecos().add(novoEndereco);
        pessoaRepository.save(pessoaLocalizada);
        return pessoaLocalizada;
    }

    public boolean exluirPessoaPorId(Long id){
        Pessoa pessoaLocalizada = pessoaRepository.findById(id).orElse(null);
        if(pessoaLocalizada != null){
            pessoaRepository.delete(pessoaLocalizada);
            return true;
        }else{
            return false;
        }
    }
}