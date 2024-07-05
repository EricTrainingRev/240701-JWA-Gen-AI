package com.revature;

import com.revature.controller.UserController;
import com.revature.entity.User;
import com.revature.repository.InMemoryUser;
import com.revature.repository.UserDao;
import com.revature.service.UserService;

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
            // this userDao will handle accessing and persisting User data
            UserDao userDao = new InMemoryUser();
            // this userService will handle validating User data follows software/business rules
            // the service needs access to the dao in order to transfer data to the repository layer
            UserService userService = new UserService(userDao);
            // this userController will handle receiving and returning data to the user
            // the controller needs access to the service in order to transfer data to the service layer
            UserController userController = new UserController(scanner, userService);
            // promptUserForService starts the whole process
            userController.promptUserForService();
        }
    }
}