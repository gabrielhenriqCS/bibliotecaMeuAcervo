package com.meuacervo.meu_acervo.repository;

import com.meuacervo.meu_acervo.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    Optional<Emprestimo> findById(Integer id);
}
