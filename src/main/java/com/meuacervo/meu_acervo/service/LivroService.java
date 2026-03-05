package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateLivroDTO;
import com.meuacervo.meu_acervo.DTOs.UpdateLivroDTO;
import com.meuacervo.meu_acervo.exception.LivroNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Livro;
import com.meuacervo.meu_acervo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public String cadastrarLivro(CreateLivroDTO dto) {
        var entity = new Livro();
        entity.setIsbn(dto.isbn());
        entity.setNome(dto.nome());
        entity.setAutor(dto.autor());
        entity.setPaginas(dto.paginas());

        var livroSalvo = livroRepository.save(entity);

        return livroSalvo.getIsbn();
    }

    public Livro buscarLivroPeloIsbn(String isbn) {
        return livroRepository.findById(isbn).orElseThrow(() -> new LivroNaoEncontradoException("Livro " + isbn + " não encontrado."));
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public void atualizarLivroPeloIsbn(String isbn, UpdateLivroDTO updateLivroDTO) {
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

    public void deletarPeloId(String isbn) {
        var livroExiste = livroRepository.existsById(isbn);
        if (livroExiste) {
            livroRepository.deleteById(isbn);
        }
    }
}
