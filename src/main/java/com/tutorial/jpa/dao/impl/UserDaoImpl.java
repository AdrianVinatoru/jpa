package com.tutorial.jpa.dao.impl;

import com.tutorial.jpa.config.DbConfig;
import com.tutorial.jpa.dao.UserDao;
import com.tutorial.jpa.entitites.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        UserEntity savedUser = null;
        EntityManager entityManager = DbConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(userEntity);
            Query query = entityManager.createNamedQuery("find UserEntity by id");
            query.setParameter("id", userEntity.getId());
            savedUser = (UserEntity) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Could not find any users", e);

        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return savedUser;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        List<UserEntity> userEntities = new ArrayList<>();
        EntityManager entityManager = DbConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            String query = "select u from UserEntity u";
            Query queryResult = entityManager.createQuery(query);
            userEntities = queryResult.getResultList();
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Could not find any users", e);

        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return userEntities;
    }

    @Override
    public List<UserEntity> findAllUsersByName() {
        List<UserEntity> userEntities = new ArrayList<>();
        EntityManager entityManager = DbConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Query namedQuery = entityManager.createNamedQuery("find UserEntity by name");
            namedQuery.setParameter("name", "stefan.seulean");
            userEntities = namedQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Could not find any users", e);

        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return userEntities;
    }

    @Override
    public void deleteUser(int userId) {
        //@todo:implementation will follow
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        //@todo:implementation will follow
        return null;
    }

    @Override
    public UserEntity findUserById(int userId) {
        //@todo:implementation will follow
        return null;
    }
}
