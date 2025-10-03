package com.meuacervo.meu_acervo.DTOs;

import java.time.LocalDateTime;

public record CreateEmprestimoDTO(LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, String livroIsbn, Integer colaboradorId) {
}
