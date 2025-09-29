package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.model.Colaborador;
import com.meuacervo.meu_acervo.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    public Optional<Colaborador> findByCpf(Integer cpf) {
        return colaboradorRepository.findByCpf(cpf);
    }

    public Optional<Colaborador> findByNome(String nome) {
        return colaboradorRepository.findByNome(nome);
    }

    public Optional<Colaborador> findByEmail(String email) {
        return colaboradorRepository.findByEmail(email);
    }

    public Optional<Colaborador> findByCargo(String cargo) {
        return colaboradorRepository.findByCargo(cargo);
    }

    public Colaborador save(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void deleteById(Integer cpf) {
        colaboradorRepository.deleteById(cpf);
    }
}
