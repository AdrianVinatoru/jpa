package com.tutorial.hibernate.dao;

import com.tutorial.hibernate.entitites.UserEntity;

import java.util.List;

public interface UserDao {

    void saveUser(UserEntity userEntity);

    List<UserEntity> findUsers();

    void updateUser(UserEntity userEntity);

    UserEntity getUserById(int id);

    void deleteUser(int userId);
}
