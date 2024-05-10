package com.treinamentodb.Projeto_DesafioCrud.repositories;

import com.treinamentodb.Projeto_DesafioCrud.core.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByCpf(String cpf);
}
