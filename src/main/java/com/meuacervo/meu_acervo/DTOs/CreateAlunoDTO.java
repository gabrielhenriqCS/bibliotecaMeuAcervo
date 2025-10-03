package com.meuacervo.meu_acervo.DTOs;


public record CreateAlunoDTO(Long ra, String nome, String email, Long telefone, Integer emprestimoId) {
}
