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
@Table(name = "colaboradorId")
public class Colaborador {
    @Setter
    @Id
    @Column(name = "cpf_colaborador", nullable = false)
    private Integer cpf;

    @Setter
    @Column(name = "nome", length = 75, nullable = false)
    private String nome;

    @Setter
    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @Setter
    @Column(name = "cargo", length = 60, nullable = false)
    private String cargo;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Colaborador() {

    }

}
