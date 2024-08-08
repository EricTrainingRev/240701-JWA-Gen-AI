package com.revature.repository;

import com.revature.entity.User;
import com.revature.utility.DatabaseConnector;
import com.revature.utility.DatabaseScriptRunner;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class SqliteUserDaoTest {

    private User positiveCreateUser;

    /*
        By coding to the interface here (setting the type of the Dao to the interface
        instead of one of the specific implementations) we can switch which version of
        the dao we want to test. Both have the same inputs and expected outputs, so our
        tests should be able to run on either option
     */
    private UserDao dao;

    @BeforeClass
    public static void testDatabaseSetup(){
        DatabaseScriptRunner.setupTestDatabase();
    }

    @Before
    public void setUp() throws Exception {
        positiveCreateUser = new User("Batman","I am the night!");
        dao = new SqliteUserDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createUserPositive() {
        User returnedUser = dao.createUser(positiveCreateUser);
        Assert.assertSame(positiveCreateUser,returnedUser);
    }

    @Test
    public void getAllUsersPositive() {
        Assert.assertTrue(dao.getAllUsers().size() >= 2);
    }

    @Test
    public void getAllUsersNegativeNoUsers(){
        deleteUsersForNegativeGetAllUsersTest();
        Assert.assertEquals(0,dao.getAllUsers().size());
    }

    public void deleteUsersForNegativeGetAllUsersTest() {
        try(Connection connection = DatabaseConnector.createConnection()){
            String sql = "delete from user";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e){
            throw new AssertionError("Could not delete users");
        }
    }
}