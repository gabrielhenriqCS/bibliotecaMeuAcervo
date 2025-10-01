package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.exception.EmprestimoNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Emprestimo;
import com.meuacervo.meu_acervo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable Integer id) {
        return emprestimoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EmprestimoNaoEncontradoException("Registro de emprestimo não encontrado"));
    }

    @PostMapping
    public Emprestimo createEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.save(emprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> updateDevolucao(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        if (emprestimoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        emprestimo.setId(id);
        Emprestimo atualizado = emprestimoService.save(emprestimo);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Emprestimo> deleteEmprestimo(@PathVariable Integer id) {
        if (emprestimoService.findById(id).isPresent()) {
            emprestimoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}