package com.meuacervo.meu_acervo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ColaboradorNaoEncontradoException extends RuntimeException{
    public ColaboradorNaoEncontradoException(String message) {
        super(message);
    }
}
