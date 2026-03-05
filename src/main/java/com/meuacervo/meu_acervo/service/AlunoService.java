package com.meuacervo.meu_acervo.service;

import com.meuacervo.meu_acervo.DTOs.CreateAlunoDTO;
import com.meuacervo.meu_acervo.DTOs.UpdateAlunoDTO;
import com.meuacervo.meu_acervo.exception.AlunoNaoEncontradoException;
import com.meuacervo.meu_acervo.exception.EmprestimoNaoEncontradoException;
import com.meuacervo.meu_acervo.model.Aluno;
import com.meuacervo.meu_acervo.repository.AlunoRepository;
import com.meuacervo.meu_acervo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class AlunoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public Long cadastrarAluno(CreateAlunoDTO dto) {
        var entity = new Aluno();
        entity.setRa(dto.ra());
        entity.setNome(dto.nome());
        entity.setEmail(dto.email());
        entity.setTelefone(dto.telefone());

        if (dto.emprestimoId() != null) {
            var emprestimoRegister = emprestimoRepository.findById(dto.emprestimoId()).orElseThrow(() -> new EmprestimoNaoEncontradoException("Empréstimo não encontrado"));
            entity.setEmprestimoId(emprestimoRegister);
        }

        var alunoSalvo = alunoRepository.save(entity);
        return alunoSalvo.getRa();
    }

    public void atualizarAlunoPeloRa(Long ra, UpdateAlunoDTO updateAlunoDTO) {
        var alunoEntity = alunoRepository.findById(ra);
        if (alunoEntity.isPresent()) {
            var aluno = alunoEntity.get();
            if (updateAlunoDTO.email() != null) {
                aluno.setEmail(updateAlunoDTO.email());
            }
            if (updateAlunoDTO.telefone() != null) {
                aluno.setTelefone(updateAlunoDTO.telefone());
            }
            alunoRepository.save(aluno);
        }
    }

    public Aluno buscarAlunoPeloRa(Long ra) {
        return alunoRepository.findById(ra).orElseThrow(() -> new AlunoNaoEncontradoException("Aluno do RA " + ra + " não encontrado."));
    }

    public List<Aluno> buscarAlunos() {
        return alunoRepository.findAll();
    }

    public void deletarPorRa(Long ra) {
        alunoRepository.deleteById(ra);
    }
}
