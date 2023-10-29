package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.Cliente;
import com.balsani.domain.model.ItemPedido;
import com.balsani.domain.model.Pedido;
import com.balsani.domain.model.Produto;
import com.balsani.domain.model.enums.StatusPedido;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OneToManyTest extends EntityManagerTest {
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

    @Test
    public void verificarRelacionamentoPedido() {
        Cliente cliente = entityManager.find(Cliente.class,1);
        Produto produto = entityManager.find(Produto.class,1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assertions.assertFalse(pedidoVerificacao.getItemPedidos().isEmpty());



    }
}
