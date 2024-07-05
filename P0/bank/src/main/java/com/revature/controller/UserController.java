package com.revature.controller;

import com.revature.service.UserService;
import com.revature.entity.User;

import java.util.Scanner;

public class UserController {

    private Scanner scanner;
    private UserService userService;

    public UserController(Scanner scanner, UserService userService){
        this.scanner = scanner;
        this.userService = userService;
    }

    public void promptUserForService(){
        // user needs to prompt they want to make an account
        System.out.println("What would you like to do?");
        System.out.println("1. register an account");
        int userActionIndicated = Integer.parseInt(scanner.nextLine());
        if (userActionIndicated == 1){
            String newUsername;
            String newPassword;
            // user needs to provide a username and password
            System.out.print("Please enter a username: ");
            newUsername = scanner.nextLine();
            System.out.print("Please enter a password: ");
            newPassword = scanner.nextLine();
            User newCredentials = new User(newUsername, newPassword);
            // TODO: get result and tell user
            userService.validateNewCredentials(newCredentials);
        } else {
            System.out.println("Goodbye!");
        }
    }

}
