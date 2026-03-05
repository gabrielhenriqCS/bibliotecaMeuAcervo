package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @Column(name = "isbn_livro", nullable = false)
    private String isbn;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "autor", length = 50, nullable = false)
    private String autor;

    @Column(name = "paginas")
    private Integer paginas;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Livro() {

    }


}
