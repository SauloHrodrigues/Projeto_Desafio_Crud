package com.treinamentodb.Projeto_DesafioCrud.service.implementacoes;

import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponseDto;
import com.treinamentodb.Projeto_DesafioCrud.core.entities.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.core.entities.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import com.treinamentodb.Projeto_DesafioCrud.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
@Component
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaResponseDto gravar(PessoaRequestDto request) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(request, pessoa);
        pessoaRepository.save(pessoa);
        PessoaResponseDto pessoaSalva = new PessoaResponseDto(pessoa.getId(), pessoa.getNome(), pessoa.getNascimento(), pessoa.getCpf(), pessoa.getEnderecos());

        return pessoaSalva ;
    }

    public PessoaResponseDto alterar(Long id, PessoaRequestDto pessoaAlterada) {
        Pessoa pessoaBuscada = pessoaRepository.findById(id).orElse(null);

        if (pessoaBuscada != null) {
            Endereco endereco = new Endereco();
//            BeanUtils.copyProperties(pessoaAlterada.getEndereco(),endereco);
            BeanUtils.copyProperties(pessoaAlterada, pessoaBuscada); //
            pessoaBuscada.getEnderecos().add(endereco);

            pessoaRepository.save(pessoaBuscada);

            return new PessoaResponseDto(pessoaBuscada.getId(), pessoaBuscada.getNome(), pessoaBuscada.getNascimento(),
            pessoaBuscada.getCpf(),pessoaBuscada.getEnderecos());
        }
        return null;
    }

    public List<PessoaResponseDto> listarPessoasCadastradas() {
        List<PessoaResponseDto> pessoaDtoList = new ArrayList<>();
        for (Pessoa p : pessoaRepository.findAll()) {
            pessoaDtoList.add(new PessoaResponseDto(p.getId(),p.getNome(),p.getNascimento(),
            p.getCpf(), p.getEnderecos()));
        }
        return pessoaDtoList;
    }

    public boolean apagarPessoa(Long id) {
        Pessoa pessoaBuscada = pessoaRepository.findById(id).orElse(null);
        if (pessoaBuscada != null) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}