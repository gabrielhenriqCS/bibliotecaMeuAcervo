package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;


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

    public Emprestimo(Integer id, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, Livro livroIsbn, Colaborador colaboradorCpf, Instant creationTimestamp, Instant updateTimestamp) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.livro = livroIsbn;
        this.colaborador = colaboradorCpf;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Emprestimo() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
