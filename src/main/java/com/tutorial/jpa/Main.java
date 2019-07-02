package com.tutorial.jpa;

import com.tutorial.jpa.entitites.UserEntity;
import com.tutorial.jpa.service.UserService;
import com.tutorial.jpa.service.impl.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String args[]) {
        System.out.println("*********Start reading the result from here************");

        UserService userService = new UserServiceImpl();

        int lastId = userService.findAllUsers().size();


        UserEntity userEntity = new UserEntity();
        userEntity.setName("Adrian " + ++lastId);
        userEntity.setPhoneNumber("0722274812");

   /*     UserEntity savedUser = userService.saveUser(userEntity);
        System.out.println("User saved in database" + savedUser);*/

        List<UserEntity> userEntityList = userService.findAllUsers();

        System.out.println("Current users in database: " + userEntityList);

        List<UserEntity> userEntitiesFromNamedQuery = userService.findAllUsersByName();
        System.out.println("User result from named query: " + userEntitiesFromNamedQuery);

        userService.deleteUser(32);
        userService.deleteUser(33);

        UserEntity userEntity1 = userService.findUserById(34);
        userService.updateUser(userEntity1);
    }
}
