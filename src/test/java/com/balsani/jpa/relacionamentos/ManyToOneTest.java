package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.Cliente;
import com.balsani.domain.model.Pedido;
import com.balsani.domain.model.enums.StatusPedido;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManyToOneTest extends EntityManagerTest {
    @Test
    public void testandoRelacionamento() {
        Cliente cliente = entityManager.find(Cliente.class,1);
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assertions.assertNotNull(pedidoVerificacao.getCliente().getNome());
    }
}
