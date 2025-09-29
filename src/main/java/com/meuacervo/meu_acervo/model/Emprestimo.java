package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "livroIsbn", nullable = false)
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "colaboradorCpf", nullable = false)
    private Colaborador colaborador;

    public Emprestimo(Integer id, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, Livro livroIsbn, Colaborador colaboradorCpf) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.livro = livroIsbn;
        this.colaborador = colaboradorCpf;
    }

    public Emprestimo() {

    }

    public int setId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro(Livro livro) {
        return livro;
    }


    public Colaborador getColaborador(Colaborador colaborador) {
        return colaborador;
    }

}
