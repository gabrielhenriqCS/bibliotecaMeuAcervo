package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.DTOs.CreateLivroDTO;
import com.meuacervo.meu_acervo.DTOs.UpdateLivroDTO;
import com.meuacervo.meu_acervo.exception.LivroNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Livro;
import com.meuacervo.meu_acervo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        var listLivros = livroService.listLivros();
        return ResponseEntity.ok(listLivros);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Livro> getLivroById(@PathVariable("isbn") String isbn) {
        return livroService.findLivroByIsbn(isbn).map(ResponseEntity::ok).orElseThrow(() -> new LivroNaoEncontradoException("ISBN " + isbn + " não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody CreateLivroDTO createLivroDTO) {
        var livroId = livroService.createLivro(createLivroDTO);
        return ResponseEntity.created(URI.create("/api/v1/livros/" + livroId)).build();
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Void> updateLivroById(@PathVariable("isbn") String isbn, @RequestBody UpdateLivroDTO updateLivroDTO) {
        livroService.updateLivroByIsbn(isbn, updateLivroDTO);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteLivro(@PathVariable("isbn") String isbn) {
        livroService.deleteById(isbn);
        return ResponseEntity.noContent().build();
    }
}
