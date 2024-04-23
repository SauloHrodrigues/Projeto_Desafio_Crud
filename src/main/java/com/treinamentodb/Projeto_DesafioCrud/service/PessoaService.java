package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.dto.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequisitarDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponderDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Component
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

//     @Override
    public ResponseEntity<Pessoa> buscarPessoaPorId(Long id) throws RuntimeException {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("No data!"));
        try {
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    public Pessoa cadastrarNovaPessoa(PessoaRequisitarDto pessoaRequisitarDto) {
        Pessoa pessoa = new Pessoa(pessoaRequisitarDto);
        return pessoaRepository.save(pessoa);//aqui é o real cadastro
    }

    public PessoaResponderDto cadastrarNovoEnderco(Long id, EnderecoRequestDto novoEndereco) {
        Endereco endereco = new Endereco(novoEndereco);
        Pessoa pessoaLocalizada = pessoaRepository.findById(id).orElse(null);
        pessoaLocalizada.getEnderecos().add(endereco);
        pessoaRepository.save(pessoaLocalizada);
        PessoaResponderDto pessoaResponderDto = new PessoaResponderDto( pessoaLocalizada);
        return pessoaResponderDto;
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