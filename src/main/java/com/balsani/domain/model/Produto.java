package com.balsani.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;
@Entity
public class Produto {
    @Id
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public Produto(){}

    private Produto(String nome, String descricao, BigDecimal preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public static Produto getInstance(String nome, String descricao, BigDecimal preco) {
        Objects.requireNonNull(nome, "Informa o nome do produto");
        Objects.requireNonNull(descricao, "Informa a descrição do produto");
        Objects.requireNonNull(nome, "Informa o preço do produto");

        return new Produto(nome, descricao, preco);
    }


    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}