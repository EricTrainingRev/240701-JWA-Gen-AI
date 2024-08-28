# GenAI Security Considerations
This document contains some examples of why you as a developer need to be considerate of security concerns when working with AI tools.

## Postgres Driver for jdk 8
Security Issue: this version of the postgresql driver has a known security vulnerability for sql injection found [here](https://nvd.nist.gov/vuln/detail/CVE-2022-31197)

Input : ```what is the most up to date postgres driver dependency compatible with JDK 8?```

Output:
```
The most up-to-date PostgreSQL driver compatible with JDK 8 is version 42.2.23. You can include it as a dependency in your project. Here is an example of how you can include it in a Maven project:
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.23</version>
</dependency>
Make sure to check for any updates or newer versions in the future.
```
Solution: make sure you have a linter checking your dependencies to catch these vulnerabilities

## JDBC Connection
Security Issue: the generated code hard-codes sensitive information in the source code

Input: ```Create a connection utility Java class that returns an initialized Connection object that can be used to perform queries to an sql database```

Output:
```
Sure! Here's an example of a Java class that creates a connection utility:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
In this example, the getConnection() method establishes a connection to the PostgreSQL database using the JDBC driver. You can replace the DB_URL, USER, and PASS variables with the appropriate values for your database.

To use this utility class, you can call the getConnection() method wherever you need a connection object to perform queries on the SQL database. Remember to handle any potential SQLExceptions that may occur.
```
Solution: request a secure format for sensitive data when requesting code generation

## Docker Compose sensitive data
Security Issue: AI will hard code sensitive data in a docker compose file without suggesting a change

Input: ```create a docker compose config that deploys a postgres database```

Output:
```
Sure! Here's an example of a Docker Compose configuration file that deploys a PostgreSQL database:
version: '3'
services:
  db:
    image: postgres
    restart: always
    environment:
      POSTGRES_USER: your_username
      POSTGRES_PASSWORD: your_password
      POSTGRES_DB: your_database
    volumes:
      - ./data:/var/lib/postgresql/data
    ports:
      - 5432:5432
In this configuration, we define a service called "db" using the postgres image. We set the environment variables POSTGRES_USER, POSTGRES_PASSWORD, and POSTGRES_DB to configure the database credentials and database name. The volumes section maps the container's data directory to a local directory called "data" in the current directory. The ports section exposes port 5432 of the container to port 5432 on the host machine.

You can save this configuration in a file named docker-compose.yml and use the command docker-compose up to start the PostgreSQL database container.
```
Solution: make sure to request the sensitive data in a more secure format, or make sure to replace the values once the code is copied over

Final Notes: 
- when working with sensitive data you should request code outlines/skeletons instead of full generation 
- be specific in your requests 
    - this requires knowing what you need/want 
- use a linter to analyze your code for security issues 
- don't hard code sensitive data into your apps
- many LLM providers will use conversations with their AI models to fine tune their newer models: if you share information with an AI tool assume the host company has access to that information
    - never share sensitive information with an AI tool.
        - [it has happened before](https://www.techradar.com/news/samsung-workers-leaked-company-secrets-by-using-chatgpt)