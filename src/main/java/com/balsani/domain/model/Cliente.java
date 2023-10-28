package com.balsani.domain.model;

import com.balsani.domain.model.enums.SexoCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
public class Cliente {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private SexoCliente sexo;






}
