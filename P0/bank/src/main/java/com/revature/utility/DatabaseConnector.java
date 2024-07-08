package com.revature.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    This utility class will handle creating database connection objects we can use
    to interact with an SQLite3 database
 */
public class DatabaseConnector {

    public static Connection createConnection() throws SQLException {
        /*
            The DriverManager will use the URL string data to determine what sql
            driver to use (sqlite in our case) and to determine where to send our
            sql queries (bank.db in the main resources' directory)
         */
        return DriverManager.getConnection("jdbc:sqlite:src/main/resources/bank.db");
    }

    // using this main method to confirm we can create a connection to our database
    public static void main(String[] args) {
        try{
            // Connection objects have auto closing capabilities
            try(Connection connection = createConnection()){
                System.out.println(connection);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
