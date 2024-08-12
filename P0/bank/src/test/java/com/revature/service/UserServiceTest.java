package com.revature.service;

import com.revature.entity.User;
import com.revature.repository.SqliteUserDao;
import com.revature.repository.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/*
    The service object has private helper methods that are required for the main service methods
    to work properly, so we can mock the Dao layer, but we can't mock the service layer, since that
    would defeat the whole point of these tests
 */
public class UserServiceTest {

    private UserDao dao;
    private UserService service;

    private User newUserCredentialsTestData;
    private User newUserUsernameTooLong;
    private User newUserPasswordTooLong;
    private User newUserBothUsernameAndPasswordTooLong;
    private List<User> premadeUsers;

    @Before
    public void setUp() throws Exception {
        dao = Mockito.mock(SqliteUserDao.class);
        service = new UserService(dao);
        newUserCredentialsTestData = new User("Batman", "I am the night");
        newUserUsernameTooLong = new User("This is a username that is too long for the service", "I am the night");
        newUserPasswordTooLong = new User("Batman", "This is a password that is too long for the service");
        newUserBothUsernameAndPasswordTooLong = new User("This is a username that is too long for the service","This is a password that is too long for the service");
        premadeUsers = new ArrayList<>();
        premadeUsers.add(new User("admin","1234"));
        premadeUsers.add(new User("admin2","12345"));
    }

    @Test
    public void validateNewCredentialsPositive() {
        // need to simulate returning the newly created user
        Mockito.when(dao.createUser(newUserCredentialsTestData))
                .thenReturn(newUserCredentialsTestData);
        // need to simulate the dao returning the current users in the database
        Mockito.when(dao.getAllUsers()).thenReturn(premadeUsers);
        Assert.assertSame(
                newUserCredentialsTestData,
                service.validateNewCredentials(newUserCredentialsTestData));
    }

    @Test
    public void validateNewCredentialsNegativeUsernameTooLong(){
        RuntimeException e =  Assert.assertThrows(RuntimeException.class, ()->{
            service.validateNewCredentials(newUserUsernameTooLong);
        });
        Assert.assertEquals("placeholder for custom exception", e.getMessage());
    }

    @Test
    public void validateNewCredentialsNegativePasswordTooLong(){
        RuntimeException e =  Assert.assertThrows(RuntimeException.class, ()->{
            service.validateNewCredentials(newUserPasswordTooLong);
        });
        Assert.assertEquals("placeholder for custom exception", e.getMessage());
    }

    @Test
    public void validateNewCredentialsNegativeBothUsernameAndPasswordTooLong(){
        RuntimeException e =  Assert.assertThrows(RuntimeException.class, ()->{
            service.validateNewCredentials(newUserBothUsernameAndPasswordTooLong);
        });
        Assert.assertEquals("placeholder for custom exception", e.getMessage());
    }


    @Test
    public void checkLoginCredentials() {
        Mockito.when(dao.getAllUsers()).thenReturn(premadeUsers);
        /*
            Because this application is primitive the argument is returned upon successful completion
            of the method, so using assertSame is an appropriate form of verification. In your own
            applications you need to check what is actually returned in a positive scenario and adjust
            your Assert statement appropriately
         */
        Assert.assertSame(premadeUsers.get(0),service.checkLoginCredentials(premadeUsers.get(0)));
    }



}