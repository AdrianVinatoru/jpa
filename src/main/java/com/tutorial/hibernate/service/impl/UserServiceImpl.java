package com.tutorial.hibernate.service.impl;


import com.tutorial.hibernate.dao.UserDao;
import com.tutorial.hibernate.dao.impl.UserDaoImpl;
import com.tutorial.hibernate.entitites.UserEntity;
import com.tutorial.hibernate.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userDao.saveUser(userEntity);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userDao.findUsers();
    }

    @Override
    public void updateUser(UserEntity userEntity, String updatedName) {
        userDao.updateUser(userEntity, updatedName);
    }

    @Override
    public UserEntity getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }
}
