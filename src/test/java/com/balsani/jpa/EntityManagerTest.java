package com.balsani.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerTest {
    public static EntityManagerFactory entityManagerFactory;
    public EntityManager entityManager;
    @BeforeAll
    public static void setupBeforeClass() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("loja");
    }
    @AfterAll
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    @BeforeEach
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }
}
