package com.meuacervo.meu_acervo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer isbn;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "autor", length = 50, nullable = false)
    private String autor;

    @Column(name = "paginas")
    private Integer paginas;

    public Livro(Integer isbn, String nome, String autor, Integer paginas) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.paginas = paginas;
    }

    public Livro() {

    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
}
