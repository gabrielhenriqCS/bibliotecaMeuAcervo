package com.meuacervo.meu_acervo.repository;

import com.meuacervo.meu_acervo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    Optional<Livro> findByIsbn(Integer isbn);
}
