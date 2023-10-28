package com.balsani.domain.model;

import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private Integer categoriaPai;
}
