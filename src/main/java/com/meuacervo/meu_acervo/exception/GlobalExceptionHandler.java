package com.meuacervo.meu_acervo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<String> handlerAlunoNaoEncontrado(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<String> handlerLivroNaoEncontrado(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ColaboradorNaoEncontradoException.class)
    public ResponseEntity<String> handlerColaboradorNaoEncontrado(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmprestimoNaoEncontradoException.class)
    public ResponseEntity<String> handlerEmprestimoNaoEncontrado(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(500, "Erro inesperado" + ex.getMessage()));
    }
}
