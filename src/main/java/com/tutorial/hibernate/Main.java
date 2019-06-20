package com.tutorial.hibernate;

import com.tutorial.hibernate.entitites.UserEntity;
import com.tutorial.hibernate.service.UserService;
import com.tutorial.hibernate.service.impl.UserServiceImpl;

import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String args[]) {

        UserService userService = new UserServiceImpl();

        UserEntity userEntity = createTestUser();

        //Save a new user using Hibernate framework
        userService.saveUser(userEntity);

        //Get all the users from the database
        List<UserEntity> users = userService.getUsers();

        //Display data from the database to check the execution of the save and get users methods
        System.out.println("Total users in the database: " + users.size());
        System.out.println("Current users in the database: " + users);
    }

    private static UserEntity createTestUser() {

        UserEntity userEntity = new UserEntity();

        userEntity.setName(UUID.randomUUID().toString());
        userEntity.setPhoneNumber(UUID.randomUUID().toString());

        return userEntity;
    }
}
