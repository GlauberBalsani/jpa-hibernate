package com.balsani.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto {
    @EqualsAndHashCode.Include
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
