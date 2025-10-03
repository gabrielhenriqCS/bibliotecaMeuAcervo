package com.meuacervo.meu_acervo.repository;

import com.meuacervo.meu_acervo.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
