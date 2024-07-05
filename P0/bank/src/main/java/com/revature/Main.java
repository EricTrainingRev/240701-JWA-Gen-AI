package com.revature;

import com.revature.controller.UserController;
import com.revature.entity.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            Registration Steps
                - user needs to prompt they want to make an account
                - user needs to provide a username and password
                - system needs to check the username and password conform to software requirements
                - system needs to save the credentials if they are valid, or reject them if they are not
                - user needs to be informed of the results
         */

        try(Scanner scanner = new Scanner(System.in)){
            UserController userController = new UserController(scanner);
            userController.promptUserForService();
        }
    }
}