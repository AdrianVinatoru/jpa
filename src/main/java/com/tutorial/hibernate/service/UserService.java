package com.tutorial.hibernate.service;

import com.tutorial.hibernate.entitites.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(UserEntity userEntity);

    List<UserEntity> getUsers();

    void updateUser(UserEntity userEntity, String updatedName);

    UserEntity getUserById(int id);

    void deleteUser(int userId);
}
