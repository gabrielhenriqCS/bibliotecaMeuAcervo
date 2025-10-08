package com.meuacervo.meu_acervo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerAlunoNaoEncontrado(AlunoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerLivroNaoEncontrado(LivroNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(ColaboradorNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerColaboradorNaoEncontrado(ColaboradorNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(EmprestimoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerEmprestimoNaoEncontrado(EmprestimoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(500, "Erro inesperado" + ex.getMessage()));
    }
}
