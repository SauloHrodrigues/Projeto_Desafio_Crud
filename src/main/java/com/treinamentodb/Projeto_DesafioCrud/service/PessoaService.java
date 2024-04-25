package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.dto.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequisitarDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponderDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.BeanUtils;
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

    public void gravar(PessoaRequisitarDto request){
        Pessoa pessoa = new Pessoa();

//        pessoa.setNome(request.getNome());
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(request.getEndereco(),endereco);
        BeanUtils.copyProperties(request,pessoa); //
        pessoa.getEnderecos().add(endereco);

        pessoaRepository.save(pessoa);

    }

}