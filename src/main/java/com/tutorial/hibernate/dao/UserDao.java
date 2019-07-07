package com.tutorial.hibernate.dao;

import com.tutorial.hibernate.entitites.UserEntity;

import java.util.List;

public interface UserDao {

    void saveUser(UserEntity userEntity);

    List<UserEntity> findUsers();

    UserEntity getUserById(int id);

    void deleteUser(int userId);

    void updateUser(UserEntity userEntity, String updatedName);
}
