package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.DTOs.CreateColaboradorDTO;
import com.meuacervo.meu_acervo.DTOs.UpdateColaboradorDTO;
import com.meuacervo.meu_acervo.model.Colaborador;
import com.meuacervo.meu_acervo.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> getAllColaboradores() {
        var listColaborador = colaboradorService.listarColaboradores();
        return ResponseEntity.ok(listColaborador);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Colaborador> getColaboradorByCpf(@PathVariable Integer cpf) {
        return ResponseEntity.ok(colaboradorService.buscarColaboradorPeloCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Colaborador> createColaborador(@RequestBody CreateColaboradorDTO createColaboradorDTO) {
        var colaboradorId = colaboradorService.cadastrarColaborador(createColaboradorDTO);
        return ResponseEntity.created(URI.create("/api/v1/colaboradores/" + colaboradorId.toString())).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Void> updateColaborador(@PathVariable("cpf") Integer cpf, UpdateColaboradorDTO updateColaboradorDTO) {
        colaboradorService.atualizarColaboradorPeloCpf(cpf, updateColaboradorDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteByCpf(@PathVariable Integer cpf) {
        colaboradorService.deletarPeloCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
