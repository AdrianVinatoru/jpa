package com.tutorial.jpa.dao;

import com.tutorial.jpa.entitites.UserEntity;

import java.util.List;

public interface UserDao {

    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> findAllUsers();

    List<UserEntity> findAllUsersByName();

    void deleteUser(int userId);

    UserEntity updateUser(UserEntity userEntity);

    UserEntity findUserById(int userId);
}
