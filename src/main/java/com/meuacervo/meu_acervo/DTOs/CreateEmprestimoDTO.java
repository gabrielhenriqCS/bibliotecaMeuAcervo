package com.meuacervo.meu_acervo.DTOs;

import com.meuacervo.meu_acervo.model.Colaborador;
import com.meuacervo.meu_acervo.model.Livro;

import java.time.LocalDateTime;

public record CreateEmprestimoDTO(Integer id, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, Livro livro, Colaborador colaborador) {
}
