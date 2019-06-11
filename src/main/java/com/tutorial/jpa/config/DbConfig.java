package com.tutorial.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConfig {

    public static EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory( "PERSISTENCE_UNIT" );
       return entityManagerFactory.createEntityManager( );
    }

    public static void closeEntityManager(EntityManager entityManager){
        entityManager.close();
    }
}
