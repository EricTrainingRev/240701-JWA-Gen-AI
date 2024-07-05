package com.revature.repository;

import com.revature.entity.User;

import java.util.List;

/*
    A Dao (Data Access Object) is a class that is meant to be used for facilitating direct
    interaction with your data persistence of choice. We will use this Dao to define
    what we want the User data persistence to look like, and then have implementation
    classes actually hold the logic of those actions
 */
public interface UserDao {

    // same as: public abstract User createUser(User newUserCredentials);
    User createUser(User newUserCredentials);
    List<User> getAllUsers();

}
