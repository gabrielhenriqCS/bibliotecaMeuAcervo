package com.meuacervo.meu_acervo.repository;

import com.meuacervo.meu_acervo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}