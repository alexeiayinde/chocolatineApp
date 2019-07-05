package dev.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("rappels-jpa");

    public EntityManagerFactory getEMF() {
        return emf;
    }

    public void closeEMF() {
        emf.close();
    }

}
