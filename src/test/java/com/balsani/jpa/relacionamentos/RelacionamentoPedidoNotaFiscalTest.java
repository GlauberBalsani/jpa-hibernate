package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.NotaFiscal;
import com.balsani.domain.model.Pedido;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class RelacionamentoPedidoNotaFiscalTest extends EntityManagerTest {

    @Test
    public void deveriaVerificarRelacionamentoPedidoENotaFiscal() {
        Pedido pedido = entityManager.find(Pedido.class,1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("TESTE");
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assertions.assertNotNull(pedidoVerificacao);
    }
}
