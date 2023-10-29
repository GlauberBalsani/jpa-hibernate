package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.*;
import com.balsani.domain.model.enums.StatusPedido;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelacionamentoTest extends EntityManagerTest {
    @Test
    public void testandoRelacionamento() {
        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoriaFilha = new Categoria();
        categoriaFilha.setNome("Infromática");
        categoriaFilha.setCategoriaPai(categoriaPai);


        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoriaFilha);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class,categoriaFilha.getId());
        Assertions.assertNotNull(categoriaVerificacao.getCategoriaPai());


    }



}
