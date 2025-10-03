package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.DTOs.CreateAlunoDTO;
import com.meuacervo.meu_acervo.exception.AlunoNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Aluno;
import com.meuacervo.meu_acervo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAlunos();
    }

    @GetMapping("/{ra}")
    public ResponseEntity<Aluno> getAlunoByRa(@PathVariable("ra") Integer ra) {
        return alunoService.findAlunoByRa(ra)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new AlunoNaoEncontradoException("Aluno com RA " + ra + " não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody CreateAlunoDTO createAlunoDTO) {
        var alunoId = alunoService.createAluno(createAlunoDTO);
        return ResponseEntity.created(URI.create("/api/v1/alunos/" + alunoId)).build();
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<Void> deleteAluno(@PathVariable("ra") Integer ra) {
        alunoService.deleteByRa(ra);
        return ResponseEntity.noContent().build();
    }
}