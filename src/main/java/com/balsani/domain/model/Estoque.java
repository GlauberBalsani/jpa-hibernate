package com.balsani.domain.model;

import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estoque {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer produtoId;
    private Integer quantidade;
}
