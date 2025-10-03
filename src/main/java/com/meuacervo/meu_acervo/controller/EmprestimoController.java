package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.DTOs.CreateEmprestimoDTO;
import com.meuacervo.meu_acervo.exception.EmprestimoNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Emprestimo;
import com.meuacervo.meu_acervo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> getAllEmprestimos() {
        var listEmprestimos = emprestimoService.listEmprestimos();
        return ResponseEntity.ok(listEmprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable("id") Integer id) {
        return emprestimoService.findEmprestimoById(id).map(ResponseEntity::ok).orElseThrow(() -> new EmprestimoNaoEncontradoException("Registro " + id + " de empréstimo não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody CreateEmprestimoDTO createEmprestimoDTO) {
        var emprestimoId = emprestimoService.createEmprestimo(createEmprestimoDTO);
        return ResponseEntity.created(URI.create("/api/v1/emprestimos/" + emprestimoId.toString())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprestimo(@PathVariable("id") Integer id) {
        emprestimoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}