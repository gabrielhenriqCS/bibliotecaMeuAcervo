package com.meuacervo.meu_acervo.repository;

import com.meuacervo.meu_acervo.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    Optional<Colaborador> findByCpf(Integer cpf);
    Optional<Colaborador> findByNome(String nome);
    Optional<Colaborador> findByEmail(String email);
    Optional<Colaborador> findByCargo(String cargo);
}
