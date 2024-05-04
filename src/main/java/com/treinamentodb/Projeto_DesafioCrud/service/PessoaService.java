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


import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaResponderDto gravar(PessoaRequisitarDto request){
        Pessoa pessoa = new Pessoa();

//        pessoa.setNome(request.getNome());
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(request.getEndereco(),endereco);
        BeanUtils.copyProperties(request,pessoa); //
        pessoa.getEnderecos().add(endereco);
        pessoaRepository.save(pessoa);
        Pessoa pessoaSalva = new Pessoa();
        for(Pessoa p : pessoaRepository.findAll()){
            if(p.getNome().equalsIgnoreCase(request.getNome())){
                pessoaSalva = p;
                break;
            }
        }
        return new PessoaResponderDto(pessoaSalva);
    }

    public PessoaResponderDto alterar(Long id, PessoaRequisitarDto pessoaAlterada){
        Pessoa pessoaBuscada = pessoaRepository.findById(id).orElse(null);

        if(pessoaBuscada != null){
            Endereco endereco = new Endereco();
//            BeanUtils.copyProperties(pessoaAlterada.getEndereco(),endereco);
            BeanUtils.copyProperties(pessoaAlterada,pessoaBuscada); //
            pessoaBuscada.getEnderecos().add(endereco);

            pessoaRepository.save(pessoaBuscada);
            return new PessoaResponderDto(pessoaRepository.findById(id).get());
        }
        return null;
    }

    public List<PessoaResponderDto> listarPessoasCadastradas() {
        List<PessoaResponderDto> pessoaDtoList= new ArrayList<>();
        for (Pessoa p : pessoaRepository.findAll()){
            pessoaDtoList.add(new PessoaResponderDto(p));
        }


        return pessoaDtoList;
    }

    public boolean apagarPessoa(Long id) {
        Pessoa pessoaBuscada = pessoaRepository.findById(id).orElse(null);
        if(pessoaBuscada != null){
           pessoaRepository.deleteById(id);
           return true;
        }
        return false;
    }
}