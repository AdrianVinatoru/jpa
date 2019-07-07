package com.tutorial.hibernate;

import java.util.List;

import com.tutorial.hibernate.entitites.UserEntity;
import com.tutorial.hibernate.service.UserService;
import com.tutorial.hibernate.service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        List<UserEntity> users = userService.getUsers();
        int size = users.size();
        int nextIndex = size == 0 ? 1 : users.get(size - 1).getId() + 1;

        // Create new user
        UserEntity user = createNewUser(nextIndex);
        userService.saveUser(user);

        // Print number of users
        System.out.println("Number of Users in db: " + ++size);

        // Print the updated list of users
        users = userService.getUsers();
        printAllUsers(users);

        //Print a user by a specific id
        System.out.println("User with id " + size + " : " + userService.getUserById(nextIndex));

        int ind = size - 1;
        userService.updateUser(users.get(ind), "Updated Name");
        System.out.println("User updated with id " + ind + " : " + userService.getUserById(ind));
    }


    private static UserEntity createNewUser(int index) {
        UserService userService = new UserServiceImpl();

        return new UserEntity("Adrian Vinatoru " + index, "074000000" + index);
    }

    private static void printAllUsers(List<UserEntity> users) {
        users.stream()
                .forEach(user -> System.out.println(user));
    }
}
