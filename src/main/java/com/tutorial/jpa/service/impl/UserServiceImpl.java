package com.tutorial.jpa.service.impl;

import com.tutorial.jpa.dao.UserDao;
import com.tutorial.jpa.dao.impl.UserDaoImpl;
import com.tutorial.jpa.entitites.UserEntity;
import com.tutorial.jpa.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity){
        return userDao.saveUser(userEntity);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public List<UserEntity> findAllUsersByName() {
        return userDao.findAllUsersByName();
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