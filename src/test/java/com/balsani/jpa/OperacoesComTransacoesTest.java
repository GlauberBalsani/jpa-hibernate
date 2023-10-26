package com.balsani.jpa;

import com.balsani.domain.model.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OperacoesComTransacoesTest extends EntityManagerTest{
    @Test
    public void abrirEFecharTransacao() {
        Produto produto = new Produto();
        /**
         * método para abrir uma transação .begin();
         * método para encerrar uma transacao .commit();
         */
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.merge(produto);
        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

    @Test
    public void fazendoUmaInsercaoNoBanco() {
        Produto produto = Produto
                .getInstance("Novo Echo Dot 5ª geração ","O Echo Dot com o melhor som já lançado | Cor Preta ", new BigDecimal("386.10"));
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
    }
}
