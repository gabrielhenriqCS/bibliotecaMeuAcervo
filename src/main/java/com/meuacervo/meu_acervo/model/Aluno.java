package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

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

    public Aluno(Long ra, String nome, String email, Long telefone, Emprestimo emprestimoId, Instant creationTimestamp, Instant updateTimestamp) {
        this.ra = ra;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.emprestimoId = emprestimoId;
    }

    public Aluno() {

    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Emprestimo getEmprestimoId() {
        return emprestimoId;
    }

    public void setEmprestimoId(Emprestimo emprestimoId) {
        this.emprestimoId = emprestimoId;
    }
}
