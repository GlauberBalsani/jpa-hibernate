package com.balsani.domain.model;

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
    private Integer pedidoId;
    private com.balsani.domain.model.enums.statusPagamento statusPagamento;
    private String codigoBarras;
}
