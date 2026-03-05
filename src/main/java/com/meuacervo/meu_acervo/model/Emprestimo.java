package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dataEmprestimo", nullable = false)
    private LocalDateTime dataEmprestimo;

    @Column(name = "dataDevolucao", nullable = false)
    private LocalDateTime dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "isbn_livro")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cpf_colaborador")
    private Colaborador colaborador;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Emprestimo() {

    }


}
