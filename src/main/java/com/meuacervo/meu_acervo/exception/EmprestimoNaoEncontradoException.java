package com.meuacervo.meu_acervo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmprestimoNaoEncontradoException extends RuntimeException {
    public EmprestimoNaoEncontradoException(String message) {
        super(message);
    }
}
