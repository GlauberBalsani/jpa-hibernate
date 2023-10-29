package com.balsani.jpa.relacionamentos;

import com.balsani.domain.model.Categoria;
import com.balsani.domain.model.Produto;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;

public class ManyToManyTest extends EntityManagerTest {

    @Test
    public void manyToManyTest() {
        Produto produto = entityManager.find(Produto.class,1);
        Categoria categoria = entityManager.find(Categoria.class,1);

        entityManager.getTransaction().begin();
        //categoria.setProdutos(Arrays.asList(produto));
        produto.setCategorias(Arrays.asList(categoria));
        entityManager.getTransaction().commit();

        entityManager.clear();
        Categoria categoriaVerificacao = entityManager.find(Categoria.class,categoria.getId());

        Assertions.assertFalse(categoriaVerificacao.getProdutos().isEmpty());

    }
}
