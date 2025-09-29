package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.model.Emprestimo;
import com.meuacervo.meu_acervo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> findById(Integer id) {
        return emprestimoRepository.findById(id);
    }

    public Emprestimo save(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void deleteById(Integer id) {
        emprestimoRepository.deleteById(id);
    }
}
