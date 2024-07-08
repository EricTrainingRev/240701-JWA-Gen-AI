package com.revature.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:src/main/resources/bank.db");
    }

    // using this main method to confirm we can create a connection to our database
    public static void main(String[] args) {
        try{
            System.out.println(createConnection());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
