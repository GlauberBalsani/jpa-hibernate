package com.balsani.app;

import com.balsani.domain.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("loja");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Produto produto = entityManager.find(Produto.class,1);
        System.out.println(produto);

        entityManager.close();
        entityManagerFactory.close();
    }
}
