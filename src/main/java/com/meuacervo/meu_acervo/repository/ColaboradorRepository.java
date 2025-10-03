package com.meuacervo.meu_acervo.repository;

import com.meuacervo.meu_acervo.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

}
