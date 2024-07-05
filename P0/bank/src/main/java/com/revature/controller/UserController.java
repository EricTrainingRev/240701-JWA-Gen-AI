package com.revature.controller;

import com.revature.service.UserService;
import com.revature.entity.User;

import java.util.Scanner;

public class UserController {

    private Scanner scanner;
    private UserService userService;

    /*
        The controller takes in a scanner and service object
            - scanner is defined outside the class and passed in, so we can
              control closing the scanner when we are done in an easier way
              (try with resources)
            - userService gives the controller access to the service layer, which will
              handle enforcing our business and software requirements
     */
    public UserController(Scanner scanner, UserService userService){
        this.scanner = scanner;
        this.userService = userService;
    }

    /*
        this promptUserForService method is our entrypoint to the bank application:
        it currently contains code to handle registering an account or exiting the
        app, but this can be refactored to handle more options (like logging). It
        also can be refactored to call helper methods to control the flow of the application
        in a more organized and readable way
     */
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
