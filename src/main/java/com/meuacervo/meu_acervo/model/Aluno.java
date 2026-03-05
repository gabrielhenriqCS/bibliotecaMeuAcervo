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
@Table(name = "aluno")
public class Aluno {
    @Id
    @Column(name = "ra_aluno", nullable = false)
    private Long ra;

    @Column(name = "nome", length = 65, nullable = false)
    private String nome;

    @Column(name = "email", length = 65, nullable = false)
    private String email;

    @Column(name = "telefone")
    private Long telefone;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimoId;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Aluno() {

    }

}
