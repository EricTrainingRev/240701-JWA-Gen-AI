package com.revature.repository;

import com.revature.entity.User;
import com.revature.exception.LoginFail;
import com.revature.exception.UserSQLException;
import com.revature.utility.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteUserDao implements UserDao{
    @Override
    public User createUser(User newUserCredentials) {
        // need sql statement
        // need a connection object
        // need to return the newly generated user

        // in PreparedStatement we can pass in the data we want to inject into our sql
        // by using ? as a placeholder for each value we want to inject into the query
        String sql = "insert into user values (?, ?)";
        try(Connection connection = DatabaseConnector.createConnection()){
            // we can use a PreparedStatement to control how the user data is injected
            // into our query. the PreparedStatement helps to format the data so to help
            // protect us from SQL injection (someone trying to mess with our database
            // via the data they provide)
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // remember that indexing for Java sql resources starts at 1, not 0
            preparedStatement.setString(1, newUserCredentials.getUsername());
            preparedStatement.setString(2, newUserCredentials.getPassword());
            // executeUpdate returns the row count affected, since we want a single
            // record created we can check that the rowCount value is 1 to know if we
            // have success or not
            int result = preparedStatement.executeUpdate();
            if (result == 1){
                return newUserCredentials;
            }
            // if we did not create the new user we throw a custom exception and handle
            // the problem somewhere else
            throw new UserSQLException("User could not be created: please try again");
        } catch (SQLException exception){
            throw new UserSQLException(exception.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        // need sql statement
        // need a connection object
        // need a list of users to return
        String sql = "select * from user";
        try(Connection connection = DatabaseConnector.createConnection()){
            // we can use a Statement object to execute our query
            Statement statement = connection.createStatement();
            // if we use executeQuery we will get a ResultSet object back with the records found
            ResultSet resultSet = statement.executeQuery(sql);
            // we make our List of users we will fill with found data
            List<User> users = new ArrayList<>();
            // loop through the ResultSet using the next() method
            while(resultSet.next()){
                // create a User object, set its properties to whatever is found in the database, and add it to the list
                User userRecord = new User();
                // you can use the column name or the column index to get the data (indexing starts at 1)
                userRecord.setUsername(resultSet.getString("username"));
                userRecord.setPassword(resultSet.getString("password"));
                users.add(userRecord);
            }
            // return the list
            return users;
        } catch (SQLException exception){
            // SQLException is a checked exception, so we need to handle it here, throw a custom exception so we can
            // handle sending the results back to the user in a more appropriate layer of the application
            throw new UserSQLException(exception.getMessage());
        }
    }
}
