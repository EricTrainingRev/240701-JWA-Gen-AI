package com.revature.repository;

import com.revature.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUser implements UserDao{

    /*
        Since we don't have access to an SQL database we can use a List to store
        user information for the time being. Lists are like more flexible arrays: you
        have access to the contiguous storage and index access, but they can also
        be resized if more resources need to be added.

        Keep in mind this list will reset every time the application stops and restarts,
        so we can set the constructor to provide starting data for us whenever the
        InMemoryUser dao is created
     */
    private List<User> users;
    public InMemoryUser(){
        users = new ArrayList<>();
        users.add(new User("admin","1234"));
    }

    @Override
    public User createUser(User newUserCredentials) {
        // since the service layer handles verifying the user credentials follow business and software
        // rules we can assume at this point they are valid and add them to the database without further
        // checks
        users.add(newUserCredentials);
        // return the user to the service layer so the username can be added to the controlMap
        return newUserCredentials;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
