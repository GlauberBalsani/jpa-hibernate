package com.balsani.domain.model;

import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NotaFiscal {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer pedidoId;
    private String xml;
    private Date dataEmissao;
}
