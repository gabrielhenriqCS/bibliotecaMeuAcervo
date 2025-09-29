package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.model.Aluno;
import com.meuacervo.meu_acervo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findByRa(Integer ra) {
        return alunoRepository.findByRa(ra);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteByRa(Integer ra) {
        alunoRepository.deleteById(ra);
    }
}
