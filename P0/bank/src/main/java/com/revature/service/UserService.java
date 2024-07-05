package com.revature.service;

import com.revature.entity.User;
import com.revature.repository.UserDao;

import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    // this will be our entrypoint into the UserService registration functionality
    public User validateNewCredentials(User newUserCredentials){
        // 1. check if lengths are correct
        if (checkUsernamePasswordLength(newUserCredentials)){
            // 2. check if username is unique
            if(checkUsernameIsUnique(newUserCredentials)){
                // 3.1 persist user data if valid, reject if not
                return userDao.createUser(newUserCredentials);
            }
        }
        // 3.2 inform user of results
        throw new RuntimeException("placeholder for custom exception");
    }


    // we will use this method to check the length of the credentials
    private boolean checkUsernamePasswordLength(User newUserCredentials){
        boolean usernameIsValid = newUserCredentials.getUsername().length() <= 30;
        boolean passwordIsValid = newUserCredentials.getPassword().length() <= 30;
        return usernameIsValid && passwordIsValid;
    }

    // we will use this method to make sure the username is unique
    private boolean checkUsernameIsUnique(User newUserCredentials){
        boolean usernameIsUnique = true;
        List<User> users = userDao.getAllUsers();
        for(User user : users){
            if(newUserCredentials.getUsername().equals(user.getUsername())){
                usernameIsUnique = false;
                break;
            }
        }
        return usernameIsUnique;
    }

}
