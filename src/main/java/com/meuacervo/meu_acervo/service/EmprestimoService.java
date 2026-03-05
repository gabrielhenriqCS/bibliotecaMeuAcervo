package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateEmprestimoDTO;
import com.meuacervo.meu_acervo.exception.ColaboradorNaoEncontradoException;
import com.meuacervo.meu_acervo.exception.EmprestimoNaoEncontradoException;
import com.meuacervo.meu_acervo.exception.LivroNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Emprestimo;
import com.meuacervo.meu_acervo.repository.ColaboradorRepository;
import com.meuacervo.meu_acervo.repository.EmprestimoRepository;
import com.meuacervo.meu_acervo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Integer cadastrarEmprestimo(CreateEmprestimoDTO dto) {
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
        var emprestimoSalvo = emprestimoRepository.save(entity);
        return emprestimoSalvo.getId();
    }

    public Emprestimo buscarEmprestimoPeloId(Integer id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new EmprestimoNaoEncontradoException("Empréstimo " + id + " não encontrado."));
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public void deletarPeloId(Integer id) {
        var emprestimoExiste = emprestimoRepository.existsById(id);
        if (emprestimoExiste) {
            emprestimoRepository.deleteById(id);
        }
    }
}
