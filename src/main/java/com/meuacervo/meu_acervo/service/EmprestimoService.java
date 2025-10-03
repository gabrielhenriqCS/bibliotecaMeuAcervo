package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateEmprestimoDTO;
import com.meuacervo.meu_acervo.model.Emprestimo;
import com.meuacervo.meu_acervo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Integer createEmprestimo(CreateEmprestimoDTO createEmprestimoDTO) {
        var entity = new Emprestimo(
                createEmprestimoDTO.id(),
                createEmprestimoDTO.dataEmprestimo(),
                createEmprestimoDTO.dataDevolucao(),
                createEmprestimoDTO.livro(),
                createEmprestimoDTO.colaborador(),
                Instant.now(),
                null
        );
        var emprestimoSaved = emprestimoRepository.save(entity);
        return emprestimoSaved.getId();
    }

    public Optional<Emprestimo> findEmprestimoById(Integer id) {
        return emprestimoRepository.findById(id);
    }

    public List<Emprestimo> listEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public void deleteById(Integer id) {
        var emprestimoExists = emprestimoRepository.existsById(id);
        if (emprestimoExists) {
            emprestimoRepository.deleteById(id);
        }
    }
}
