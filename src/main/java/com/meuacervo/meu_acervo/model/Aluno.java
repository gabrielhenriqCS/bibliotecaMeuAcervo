package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Aluno(Integer ra, String nome, String email, Integer telefone) {
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
