package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateAlunoDTO;
import com.meuacervo.meu_acervo.model.Aluno;
import com.meuacervo.meu_acervo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Integer createAluno(CreateAlunoDTO createAlunoDTO) {
        var entity = new Aluno(
                createAlunoDTO.ra(),
                createAlunoDTO.nome(),
                createAlunoDTO.email(),
                createAlunoDTO.telefone(),
                createAlunoDTO.emprestimoId(),
                Instant.now(),
                null
        );
        var alunoSaved = alunoRepository.save(entity);
        return alunoSaved.getRa();
    }

    public Optional<Aluno> findAlunoByRa(Integer ra) {
        return alunoRepository.findById(ra);
    }

    public List<Aluno> findAlunos() {
        return alunoRepository.findAll();
    }

    public void deleteByRa(Integer ra) {
        alunoRepository.deleteById(ra);
    }
}
