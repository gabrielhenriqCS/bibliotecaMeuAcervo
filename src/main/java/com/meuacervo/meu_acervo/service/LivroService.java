package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateLivroDTO;
import com.meuacervo.meu_acervo.model.Livro;
import com.meuacervo.meu_acervo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public String createLivro(CreateLivroDTO createLivroDTO) {
        var entity = new Livro(
                createLivroDTO.isbn().toString(),
                createLivroDTO.nome(),
                createLivroDTO.autor(),
                createLivroDTO.paginas(),
                Instant.now(),
                null);

        var livroSaved = livroRepository.save(entity);

        return livroSaved.getIsbn();
    }

    public Optional<Livro> findLivroByIsbn(String isbn) {
        return livroRepository.findById(isbn);
    }

    public List<Livro> listLivros() {
        return livroRepository.findAll();
    }

    public void deleteById(String isbn) {
        var livroExists = livroRepository.existsById(isbn);
        if (livroExists) {
            livroRepository.deleteById(isbn);
        }
    }
}
