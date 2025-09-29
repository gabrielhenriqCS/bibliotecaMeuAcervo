package com.meuacervo.meu_acervo.controller;

import com.meuacervo.meu_acervo.model.Colaborador;
import com.meuacervo.meu_acervo.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> getAllColaboradores() {
        return colaboradorService.findAll();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Colaborador> getColaboradorByCpf(@PathVariable Integer cpf) {
        return colaboradorService.findByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Colaborador> getColaboradorByNome(@PathVariable String nome) {
        return colaboradorService.findByNome(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Colaborador> getColaboradorByEmail(@PathVariable String email) {
        return colaboradorService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<Colaborador> getColaboradorByCargo(@PathVariable String cargo) {
        return colaboradorService.findByCargo(cargo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.save(colaborador);
    }

    @PutMapping("/cpf/{cpf}")
    public ResponseEntity<Colaborador> updateColaborador(@PathVariable Integer cpf,
                                                         @RequestBody Colaborador colaboradorDetalhes) {
        return colaboradorService.findByCpf(cpf).map(colaboradorExist -> {
            colaboradorExist.setNome(colaboradorDetalhes.getNome());
            colaboradorExist.setEmail(colaboradorDetalhes.getEmail());
            colaboradorExist.setCargo(colaboradorDetalhes.getCargo());
            Colaborador atualizado = colaboradorService.save(colaboradorExist);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cpf/{cpf}")
    public ResponseEntity<Void> deleteByCpf(@PathVariable Integer cpf) {
        if (colaboradorService.findByCpf(cpf).isPresent()) {
            colaboradorService.deleteById(cpf);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
