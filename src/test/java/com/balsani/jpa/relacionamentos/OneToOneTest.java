package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.PagamentoCartao;
import com.balsani.domain.model.Pedido;
import com.balsani.domain.model.enums.StatusPagamento;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneToOneTest extends EntityManagerTest {

    @Test
    public void oneToOneTest() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumero("1234");
        pagamentoCartao.setStatusPagamento(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);



        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao  = entityManager.find(Pedido.class, pedido.getId());
        Assertions.assertNotNull(pedidoVerificacao.getPagamentoCartao());
    }

}
