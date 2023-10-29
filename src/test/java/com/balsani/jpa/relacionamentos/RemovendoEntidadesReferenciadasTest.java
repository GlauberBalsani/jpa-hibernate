package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.Pedido;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

    @Test
    public void removerEntidadeRelacionada() {
        Pedido pedido = entityManager.find(Pedido.class,1);

        Assertions.assertFalse(pedido.getItemPedidos().isEmpty());

        entityManager.getTransaction().begin();
        pedido.getItemPedidos().forEach(i -> entityManager.remove(i));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,1);
        Assertions.assertNull(pedidoVerificacao);


    }
}
