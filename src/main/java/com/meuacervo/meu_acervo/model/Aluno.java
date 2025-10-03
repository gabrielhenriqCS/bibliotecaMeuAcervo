package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @Column(name = "ra_aluno", nullable = false)
    private Integer ra;

    @Column(name = "nome", length = 65, nullable = false)
    private String nome;

    @Column(name = "email", length = 65, nullable = false)
    private String email;

    @Column(name = "telefone")
    private Integer telefone;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimoId;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Aluno(Integer ra, String nome, String email, Integer telefone, Emprestimo emprestimo, Instant now, Object o) {
        this.ra = ra;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Aluno() {

    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
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

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
}
