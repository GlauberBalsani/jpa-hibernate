package com.balsani.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PagamentoBoleto {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedidoId;
    private com.balsani.domain.model.enums.statusPagamento statusPagamento;
    private String codigoBarras;
}
