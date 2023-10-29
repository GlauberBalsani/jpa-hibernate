package com.balsani.jpa;

import com.balsani.domain.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OperacoesComTransacoesTest extends EntityManagerTest{
    @Test
    public void abrirEFecharTransacao() {
        Produto produto = new Produto();
        /**
         * método para abrir uma transação .begin();
         * método para encerrar uma transação .commit();
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
        entityManager.getTransaction().commit();
    }

    @Test
    public void fazendoUmaRemocao() {
        Produto produto = new Produto();
        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class,3);
        Assertions.assertNull(produtoVerificacao);
    }

    @Test
    public void fazendoUmaConsulta() {
        entityManager.getTransaction().begin();
        entityManager.find(Produto.class,4);
        entityManager.getTransaction().commit();
    }

    @Test
    public void realizarUmaAtualizacao() {
        Produto produto = new Produto();


        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("Novo Kindle");
        produto.setPreco(new BigDecimal("599.99"));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class,produto.getId());
        Assertions.assertNotNull(produtoVerficacao);
        Assertions.assertEquals("Kindle Paperwhite",produtoVerficacao.getNome());
    }

    @Test
    public void realizarUmaAtualizacaoEmObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class,1);
        produto.setNome("Kindle Paperwhite Segunda Geração");
        produto.setPreco(new BigDecimal("655.54"));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class,produto.getId());

        Assertions.assertEquals("Kindle Paperwhite Segunda Geração",produtoVerficacao.getNome());
    }

    @Test
    public void realizarUmaInsercaoComMerge() {
        Produto produto = new Produto();

        produto.setNome("HP 2774 DeskJet Ink Advantage");
        produto.setDescricao(" Impressora Multifuncional, Wi-Fi, Scanner, Tecnologia de Impressão HP Thermal Inkjet, Funções: Impressão, Cópia, Digitalização ");
        produto.setPreco(new BigDecimal("329.00"));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class,produto.getId());
        Assertions.assertNotNull(produtoVerificacao);


    }



}
