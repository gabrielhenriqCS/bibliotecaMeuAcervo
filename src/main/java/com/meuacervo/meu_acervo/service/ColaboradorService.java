package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateColaboradorDTO;
import com.meuacervo.meu_acervo.model.Colaborador;
import com.meuacervo.meu_acervo.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Integer createColaborador(CreateColaboradorDTO createColaboradorDTO) {
        var entity = new Colaborador(
                createColaboradorDTO.cpf(),
                createColaboradorDTO.nome(),
                createColaboradorDTO.email(),
                createColaboradorDTO.cargo(),
                Instant.now(),
                null
        );
        var colaboradorSaved = colaboradorRepository.save(entity);
        return colaboradorSaved.getCpf();
    }

    public Optional<Colaborador> findColaboradorByCpf(Integer cpf) {
        return colaboradorRepository.findById(cpf);
    }

    public List<Colaborador> listColaboradores() {
        return colaboradorRepository.findAll();
    }

    public void deleteByCpf(Integer cpf) {
        colaboradorRepository.deleteById(cpf);
    }
}
