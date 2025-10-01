package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.exception.AlunoNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Aluno;
import com.meuacervo.meu_acervo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }

    @GetMapping("/{ra}")
    public ResponseEntity<Aluno> getAlunoByRa(@PathVariable Integer ra) {
        return alunoService.findByRa(ra)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new AlunoNaoEncontradoException("Aluno com RA " + ra + " não encontrado"));
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping("/{ra}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Integer ra, @RequestBody Aluno alunoDetalhes) {
        return alunoService.findByRa(ra).map(alunoExist -> {
            alunoExist.setNome(alunoDetalhes.getNome());
            alunoExist.setEmail(alunoDetalhes.getEmail());
            alunoExist.setTelefone(alunoDetalhes.getTelefone());
            Aluno atualizado = alunoService.save(alunoExist);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Integer ra) {
        if (alunoService.findByRa(ra).isPresent()) {
            alunoService.deleteByRa(ra);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}