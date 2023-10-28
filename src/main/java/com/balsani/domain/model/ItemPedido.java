package com.balsani.domain.model;

import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedidoId;
    private Integer produtoID;
    private BigDecimal precoProduto;
    private Integer quantidade;
}
