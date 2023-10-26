package com.balsani.jpa;

import com.balsani.domain.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {
    @Test
    public void buscarPorIdentificador() {
        Produto produto = entityManager.find(Produto.class,1);

        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle",produto.getNome());
    }
}
