package com.balsani.jpa.mapeamento;

import com.balsani.domain.model.Categoria;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapeandoChavesPrimariasTest extends EntityManagerTest {

    @Test
    public void testandoMapeamentoDasChavesPrimarias() {
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class,categoria.getId());
        Assertions.assertNotNull(categoriaVerificacao);
    }
}
