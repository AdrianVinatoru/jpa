package com.tutorial.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tutorial.jpa.config.DbConfig;
import com.tutorial.jpa.dao.UserDao;
import com.tutorial.jpa.entitites.UserEntity;

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
        EntityManager entityManager = DbConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Query deleteQuery = entityManager.createNativeQuery("DELETE FROM public.users WHERE id = " + userId);
            deleteQuery.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Could not delete user with id: " + userId, e);
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        EntityManager entityManager = DbConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {

            Query updateQuery = entityManager.createNamedQuery("update UserEntity by id");
            updateQuery.setParameter("name", "IONUT23").
                    setParameter("id", userEntity.getId()).
                    executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Could not delete user with id: " + userEntity.getId(), e);
        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return userEntity;
    }

    @Override
    public UserEntity findUserById(int userId) {
        UserEntity user = null;
        EntityManager entityManager = DbConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Query namedQuery = entityManager.createNamedQuery("find UserEntity by id");
            namedQuery.setParameter("id", userId);
            user = (UserEntity) namedQuery.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Could not find any user", e);

        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return user;
    }
}
