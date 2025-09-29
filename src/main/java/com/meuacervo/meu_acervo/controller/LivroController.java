package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.model.Livro;
import com.meuacervo.meu_acervo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Integer isbn) {
        return livroService.findByIsbn(isbn).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Integer isbn, @RequestBody Livro livroDetalhes) {
        return livroService.findByIsbn(isbn)
                .map(livroExiste -> {
                    livroExiste.setNome(livroDetalhes.getNome());
                    livroExiste.setAutor(livroDetalhes.getAutor());
                    livroExiste.setPaginas(livroDetalhes.getPaginas());
                    Livro atualizado = livroService.save(livroExiste);
                    return ResponseEntity.ok(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Livro> deleteLivro(@PathVariable Integer isbn) {
        if (livroService.findByIsbn(isbn).isPresent()) {
            livroService.deleteById(isbn);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
