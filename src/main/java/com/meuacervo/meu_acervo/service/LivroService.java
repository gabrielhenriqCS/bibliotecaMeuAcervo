package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateLivroDTO;
import com.meuacervo.meu_acervo.DTOs.UpdateLivroDTO;
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

    public String createLivro(CreateLivroDTO dto) {
        var entity = new Livro();
        entity.setIsbn(dto.isbn());
        entity.setNome(dto.nome());
        entity.setAutor(dto.autor());
        entity.setPaginas(dto.paginas());

        var livroSaved = livroRepository.save(entity);

        return livroSaved.getIsbn();
    }

    public Optional<Livro> findLivroByIsbn(String isbn) {
        return livroRepository.findById(isbn);
    }

    public List<Livro> listLivros() {
        return livroRepository.findAll();
    }

    public void updateLivroByIsbn(String isbn, UpdateLivroDTO updateLivroDTO) {
        var livroEntity = livroRepository.findById(isbn);
        if (livroEntity.isPresent()) {
            var livro = livroEntity.get();
            if (updateLivroDTO.nome() != null) {
                livro.setNome(updateLivroDTO.nome());
            }

            if (updateLivroDTO.paginas() != null) {
                livro.setPaginas(updateLivroDTO.paginas());
            }
            livroRepository.save(livro);
        }
    }

    public void deleteById(String isbn) {
        var livroExists = livroRepository.existsById(isbn);
        if (livroExists) {
            livroRepository.deleteById(isbn);
        }
    }
}
