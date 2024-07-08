package com.revature;

import com.revature.controller.UserController;
import com.revature.repository.SqliteUserDao;
import com.revature.repository.UserDao;
import com.revature.service.UserService;

import java.util.HashMap;
import java.util.Map;
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
            UserDao userDao = new SqliteUserDao();
            // this userService will handle validating User data follows software/business rules
            // the service needs access to the dao in order to transfer data to the repository layer
            UserService userService = new UserService(userDao);
            // this userController will handle receiving and returning data to the user
            // the controller needs access to the service in order to transfer data to the service layer
            UserController userController = new UserController(scanner, userService);
            // this Map will update the loopApplication boolean and store the logged-in user data
            Map<String, String> controlMap = new HashMap<>();
            controlMap.put("Continue Loop", "true");
            while(Boolean.parseBoolean(controlMap.get("Continue Loop"))){
                // we pass the controlMap into the promptUserForService to get the potential user data and
                // check it in the next if statement
                userController.promptUserForService(controlMap);
                if(controlMap.containsKey("User")){
                    System.out.printf("Banking stuff for %s can happen here! Press any key to continue", controlMap.get("User"));
                    scanner.nextLine();
                    /*
                        NOTE: currently the User information has no means of being removed: when you implement a log out
                        functionality the controlMap needs to have the User key/value pair removed:
                        - controlMap.remove("User");
                     */
                }
            }

        }
    }
}