package com.balsani.domain.model;

import com.balsani.domain.model.enums.StatusPedido;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private LocalDateTime dataPedido;
    private LocalDateTime dataConclusao;
    private Integer notaFiscalId;
    private BigDecimal total;
    private StatusPedido satus;
}
