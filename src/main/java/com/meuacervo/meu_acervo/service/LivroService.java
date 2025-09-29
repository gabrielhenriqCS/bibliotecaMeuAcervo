package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.model.Livro;
import com.meuacervo.meu_acervo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findByIsbn(Integer isbn) {
        return livroRepository.findByIsbn(isbn);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deleteById(Integer isbn) {
        livroRepository.deleteById(isbn);
    }
}
