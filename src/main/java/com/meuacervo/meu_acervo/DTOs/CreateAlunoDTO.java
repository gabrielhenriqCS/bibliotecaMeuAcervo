package com.meuacervo.meu_acervo.DTOs;

import com.meuacervo.meu_acervo.model.Emprestimo;

public record CreateAlunoDTO(Integer ra, String nome, String email, Integer telefone, Emprestimo emprestimoId) {
}
