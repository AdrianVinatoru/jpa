package com.tutorial.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tutorial.hibernate.config.HibernateConfig;
import com.tutorial.hibernate.dao.UserDao;
import com.tutorial.hibernate.entitites.UserEntity;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(UserEntity userEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            //Start a transaction
            transaction = session.beginTransaction();
            //Save a user in the database
            session.save(userEntity);
            //Commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException();
        }
    }

    @Override
    public List<UserEntity> findUsers() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from UserEntity", UserEntity.class).list();
        }
    }

    @Override
    public void updateUser(UserEntity userEntity, String updatedName) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            //Start a transaction
            transaction = session.beginTransaction();

            //Update a user in the database
            UserEntity initialUser = getUserById(userEntity.getId());
            initialUser.setName(updatedName);
            session.update(initialUser);

            //Commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException();
        }

    }

    @Override
    public UserEntity getUserById(int id) {
        UserEntity userEntity = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            //Get a user by id
            userEntity = session.load(UserEntity.class, id);
        }
        return userEntity;
    }

    @Override
    public void deleteUser(int userId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            //Start a transaction
            transaction = session.beginTransaction();

            //Delete a user in the database
            UserEntity initialUser = getUserById(userId);
            session.delete(initialUser);

            //Commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException();
        }
    }
}
