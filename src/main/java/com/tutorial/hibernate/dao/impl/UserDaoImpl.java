package com.tutorial.hibernate.dao.impl;

import com.tutorial.hibernate.config.HibernateConfig;
import com.tutorial.hibernate.dao.UserDao;
import com.tutorial.hibernate.entitites.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
    public void updateUser(UserEntity userEntity) {
        //@todo:implement this method as an exercise
    }

    @Override
    public UserEntity getUserById(int id) {
        //@todo:implement this method as an exercise
        return null;
    }

    @Override
    public void deleteUser(int userId) {
        //@todo:implement this method as an exercise
    }
}
