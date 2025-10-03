package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateColaboradorDTO;
import com.meuacervo.meu_acervo.DTOs.UpdateColaboradorDTO;
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

    public Integer createColaborador(CreateColaboradorDTO dto) {
        var entity = new Colaborador();
        entity.setCpf(dto.cpf());
        entity.setNome(dto.nome());
        entity.setEmail(dto.email());
        entity.setCargo(dto.cargo());
        var colaboradorSaved = colaboradorRepository.save(entity);
        return colaboradorSaved.getCpf();
    }

    public void updateColaboradorByCpf(Integer cpf, UpdateColaboradorDTO updateColaboradorDTO) {
        var colaboradorEntity = colaboradorRepository.findById(cpf);
        if (colaboradorEntity.isPresent()) {
            var colaborador = colaboradorEntity.get();
            if (updateColaboradorDTO.email() != null) {
                colaborador.setEmail(updateColaboradorDTO.email());
            }

            if (updateColaboradorDTO.cargo() != null) {
                colaborador.setCargo(updateColaboradorDTO.cargo());
            }
            colaboradorRepository.save(colaborador);
        }
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
