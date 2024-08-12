package com.revature.controller;

import com.revature.entity.User;
import com.revature.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserControllerTest {

    private Scanner scanner;
    private UserService service;
    private UserController controller;

    private String registrationSelect;

    private User registrationUserPositive;

    /*
        Because of the need to work around the scanner object the controller requires, we can't
        make use of a @Before setup method to initialize your controller object. We can initialize
        test data before hand, but the scanner will need to be given an input to scan through for
        each test that is going to change depending on what is being tested.
     */
    @Before
    public void setup(){
        // the \n character is to simulate the user clicking enter
        registrationSelect = "1\nBatman\nI am the night\n";
        registrationUserPositive = new User("Batman", "I am the night");
    }

    @Test
    public void promptUserForServiceRegisterAccount() {
        /*
            There are a lot of different ways we could test the prompt user for service method,
            this particular test case is simply verifying that a user, when they prompt to
            register, and when they provide valid username/password for their credentials, don't
            trigger any exceptions. We could make this a more robust test by redirecting the Standard
            Output to a String value and checking the output is what we want for each step of the method, but
            that would require a lot more setup
         */
        try{
            /*
                Instead of providing System.in like the actual implementation we can provide a string
                with the user input we want to simulate.

                Keep in mind that a new Test Class object is created for each test case, so you
                don't have to worry about resetting your test objects (scanner, service, controller)
                in between tests to avoid unintended behavior, but you will have to close any
                resources that require it (just the scanner in this case)
             */
            scanner = new Scanner(registrationSelect);
            service = Mockito.mock(UserService.class);
            controller = new UserController(scanner, service);
            Mockito.when(service.validateNewCredentials(registrationUserPositive)).thenReturn(registrationUserPositive);
            /*
                This test just passes in a HashMap, but making a test object to represent the control map
                would be more sustainable in the long run. Some tests may be simplified if we can pre-load
                data into the map
             */
            controller.promptUserForService(new HashMap<>());
        } finally {
            // need to make sure to close the scanner. This is a good use case for an @After method
            scanner.close();
        }

    }

    @Test
    public void registerNewUser() {
    }

    @Test
    public void login() {
    }

    @Test
    public void getUserCredentials() {
    }
}