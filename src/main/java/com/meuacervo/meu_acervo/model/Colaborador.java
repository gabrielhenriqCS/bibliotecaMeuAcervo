package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @Column(name = "cpf_colaborador", nullable = false)
    private Integer cpf;

    @Column(name = "nome", length = 75, nullable = false)
    private String nome;

    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @Column(name = "cargo", length = 60, nullable = false)
    private String cargo;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Colaborador(Integer cpf, String nome, String email, String cargo, Instant creationTimestamp, Instant updateTimestamp) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
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
