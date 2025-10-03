package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateEmprestimoDTO;
import com.meuacervo.meu_acervo.exception.ColaboradorNaoEncontradoException;
import com.meuacervo.meu_acervo.exception.LivroNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Emprestimo;
import com.meuacervo.meu_acervo.repository.ColaboradorRepository;
import com.meuacervo.meu_acervo.repository.EmprestimoRepository;
import com.meuacervo.meu_acervo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Integer createEmprestimo(CreateEmprestimoDTO dto) {
        var entity = new Emprestimo();
        entity.setDataEmprestimo(dto.dataEmprestimo());
        entity.setDataDevolucao(dto.dataDevolucao());

        if (dto.colaboradorId() != null) {
            var colaboradorId = colaboradorRepository.findById(dto.colaboradorId()).orElseThrow(() -> new ColaboradorNaoEncontradoException("ID do colaborador não encontrado"));
            entity.setColaborador(colaboradorId);
        }

        if (dto.livroIsbn() != null) {
            var livroIsbn = livroRepository.findById(dto.livroIsbn()).orElseThrow(() -> new LivroNaoEncontradoException("ISBN do livro não foi encontrado"));
            entity.setLivro(livroIsbn);
        }
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
