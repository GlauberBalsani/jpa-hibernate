package com.balsani.domain.model;

import com.balsani.domain.model.enums.StatusPagamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pagamento_boleto")
public class PagamentoBoleto {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Column(name = "status_pagamento")
    private StatusPagamento status;
    @Column(name = "codigo_barras")
    private String codigoBarras;
}
