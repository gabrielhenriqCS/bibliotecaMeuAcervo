package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cpf;

    @Column(name = "nome", length = 75, nullable = false)
    private String nome;

    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @Column(name = "cargo", length = 60, nullable = false)
    private String cargo;

    public Colaborador(Integer cpf, String nome, String email, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Colaborador() {

    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
