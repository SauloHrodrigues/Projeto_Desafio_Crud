package com.treinamentodb.Projeto_DesafioCrud.service.interfaces;

import com.treinamentodb.Projeto_DesafioCrud.dto.EnderecoRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequisitarDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponderDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PessoaInterface {

    public List<Pessoa> listarPessoas();

    public ResponseEntity<Pessoa> buscarPessoaPorId(Long id) throws RuntimeException;

    public Pessoa cadastrarNovaPessoa(PessoaRequisitarDto pessoaRequisitarDto);

    public PessoaResponderDto cadastrarNovoEnderco(Long id, EnderecoRequestDto novoEndereco);

    public boolean exluirPessoaPorId(Long id);


}
