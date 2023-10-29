package com.balsani.jpa.mapeamento;

import com.balsani.domain.model.Cliente;
import com.balsani.domain.model.enums.SexoCliente;
import com.balsani.jpa.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapeandoEnumsTest extends EntityManagerTest {

    @Test
    public void testeDeEnum() {
        Cliente cliente = new Cliente();

        cliente.setNome("Zé da Manga");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerficacao = entityManager.find(Cliente.class,cliente.getId());
        Assertions.assertNotNull(clienteVerficacao);
    }
}
