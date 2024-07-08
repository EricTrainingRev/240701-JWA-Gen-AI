package com.revature.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

/*
    This class is used to execute the sql script located in the main resources directory. It splits
    the sql script into individual statements and executes them one at a time, committing all statements
    at the end of the script
*/

public class DatabaseScriptRunner {

    public static void main(String[] args) {
        /*
            Paths has a get method that lets us return a file path as a Path object
            we can then provide to the Files class in order to streamline returning
            a Stream of String data that is the SQL we want to execute
         */
        // we get the Path data
        Path sqlPath = Paths.get("src/main/resources/bank_setup_reset_script.sql");
        try{
            try(
                    // create our connection object in our try with resources block
                    Connection connection = DatabaseConnector.createConnection();
                    // create a Stream that has our sql lines saved as String data
                    Stream<String> lines = Files.lines(sqlPath)
            ){
                // by setting auto commit to false we can execute multiple statements
                // and then commit them all together, ensuring all data or no data
                // is updated
                connection.setAutoCommit(false);
                StringBuilder sqlBuilder = new StringBuilder();
                // this line loops through our stream and appends each line of the file
                // to the StringBuilder object
                lines.forEach(line -> sqlBuilder.append(line));
                String sql = sqlBuilder.toString();
                // we can now split the sql into individual statements
                // the \\R character is a more robust newline indicator
                // this means new line, carriage return, and one or two other
                // characters are referenced by it
                String[] statements = sql.split(";");
                // for each statement we need executed we make a Statement object and call
                // the executeUpdate method, passing in our sql String statement
                for(String statement : statements){
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(statement);
                }
                connection.commit();
            }
        // need to catch potential SQL and IO Exceptions
        } catch (SQLException | IOException exception){
            System.out.println(exception.getMessage());
        }
    }

}
