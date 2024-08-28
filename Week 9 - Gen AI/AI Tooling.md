# AI Tooling Study Guide
A Few Notes Before Starting: Due to the rapid pace of AI development and general nature of generative AI there is a good chance you will not be able to reproduce the AI outputs below 1 to 1. Consider the provided examples more as general guidelines for approaching these topics. [Codeium](https://codeium.com/) was used for the code examples below.

## Code Generation
Your AI Co-Pilot is only as good as the context you give it: this means more detailed asks will require more detailed questions. Imagine you want to create an entity to represent "Person" data you need persisted in a database. This data should have an identifier, first and last name, and an age field: just telling your AI co-pilot "create a Person entity" leaves a lot of room for interpretation for the AI and in no way shape or form tells the AI what data you need the entity to contain. 

Input: ````create a Person Entity```
Output:
```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
```
Not exactly a usable solution for a Java application due to the generated code being Python. The AI will need more detailed information to create the entity correctly:

Input: ```Create a Person entity in Java```

Output:
```java
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    
    // constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    // getters and setters
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```
Note the AI got the first and last name, and even has the makings of a Java Bean, but it did not provide an Id field by default. The AI needs more details in the instructions to hit all the requirements.

Input: ```Create a Java bean called "Person" with an int id, string first and last name, and int age field. Make sure to override the toString, hashCode, and equals methods.```

Output:
```java
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    
    // Constructor
    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // Override toString() method
    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }
    
    // Override hashCode() method
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
    
    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
}
```
We are getting more detail now: depending on what your needs are you can adjust the prompt to fit accordingly.

Keep the following points in mind when using AI to generate code for you: 
- The AI only knows what you tell it about your code 
- The more detailed your request the higher the likelihood the AI will generate usable and complete code 
- Long form "conversations" with the AI can help the AI "remember" the context of your code base 
- Use imperative language when you want the AI to generate code for you

## Code Testing
When using AI to assist with testing you need to keep in mind where you are in the process of the Standard Development Life Cycle: Are you doing TDD and therefore need your tests before your implementation code, or are you retroactively testing code you already made?

It is easier to get your AI tool to create reasonable tests for pre-existing code, so all the guidelines for the general code generation apply. This demo will focus on using AI to build tests for methods that are not yet implemented, like in a TDD scenario. You can use the Person object developed earlier for this demo:
```java
package com.example;

public interface PersonDao { 
    
    // should return the created person
    Person create(Person person);
    
    // should return the person with the given id
    Person read(int id);
    
    // should return the # of rows updated
    int update(Person person);
    
    // should return the # of rows deleted
    int delete(int id);
}
```
```java
package com.example;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person create(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Person read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public int update(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
```
Tools like Codeium provide a format for providing code context to the AI (@resource for Codeium in the chat), but even with context the dao does not provide much detail for the AI to work with. With this in mind, an AI is going to be more useful in providing boilerplate for your tests than the actual code. Here is an example of just telling the AI write the unit tests

Input: ```create a unit test for each method in the PersonDaoImpl class @class:PersonDaoImpl```

Output:
```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonDaoImplTest {

    private PersonDaoImpl personDao;

    @BeforeEach
    public void setUp() {
        personDao = new PersonDaoImpl();
    }

    @Test
    public void testCreate() {
        // Given
        Person person = new Person(1, "John", "Doe", 30);

        // When
        Person createdPerson = personDao.create(person);

        // Then
        assertEquals(person, createdPerson);
    }

    @Test
    public void testRead() {
        // Given
        int id = 1;
        Person expectedPerson = new Person(id, "John", "Doe", 30);

        // When
        Person actualPerson = personDao.read(id);

        // Then
        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void testUpdate() {
        // Given
        Person person = new Person(1, "John", "Doe", 30);

        // When
        int numRowsUpdated = personDao.update(person);

        // Then
        assertEquals(1, numRowsUpdated);
    }

    @Test
    public void testDelete() {
        // Given
        int id = 1;

        // When
        int numRowsDeleted = personDao.delete(id);

        // Then
        assertEquals(1, numRowsDeleted);
    }

    @Test
    public void testUnimplementedMethods() {
        // Given
        Person person = new Person(1, "John", "Doe", 30);

        // Then
        assertThrows(UnsupportedOperationException.class, () -> personDao.create(person));
        assertThrows(UnsupportedOperationException.class, () -> personDao.read(1));
        assertThrows(UnsupportedOperationException.class, () -> personDao.update(person));
        assertThrows(UnsupportedOperationException.class, () -> personDao.delete(1));
    }
}
```
A quick glance at the code seems like we have our tests ready to go, but there are issues that need to be addressed: 
- the dao is hard coded to PersonDaoimpl instead of coding to the interface 
- 3 of the 4 tests require the create person test to run first and be successful for them to work - while it could technically work, the update test doesn't actually update the Person data as it currently exists 
- the test unimplemented methods test is unnecessary - test inputs and expected results are defined in-method instead of a setup method

So, even though the AI generated a significant portion of code for us, we still need to go in and fix a lot of the data, so it's a bit of a wash overall. Instead of just requesting unit tests we should be more specific with what kind of boilerplate code we want, what kind of tests we want, and how the AI should handle the code in the tests.

Input: ```define a method signature for a unit test for each method in the PersonDaoImpl class @class:PersonDaoImpl. Do not write any logic for the tests, just create the method signatures```

Output:
```java
public class PersonDaoImplTest {

    // Test for create method
    @Test
    public void testCreate() {
        // TODO: Add test logic
    }

    // Test for read method
    @Test
    public void testRead() {
        // TODO: Add test logic
    }

    // Test for update method
    @Test
    public void testUpdate() {
        // TODO: Add test logic
    }

    // Test for delete method
    @Test
    public void testDelete() {
        // TODO: Add test logic
    }
}
```
Next step we can have an implementation object instantiated before each test

Input: ```create a setup method that instantiates a PersonDaoimpl object of the PersonDao @class:PersonDao type before each test. The instantiated object should be a static field of the test class```

Output:
```java
public class PersonDaoImplTest {

    private static PersonDao personDao;

    @BeforeEach
    public void setUp() {
        personDao = new PersonDaoImpl();
    }

    // Rest of the test methods...
}
```
note in this case the code was provided without the extra details: it is a simple matter to copy and paste the results over, but make sure to properly import the required resources.

Now you are ready to write your tests. It is not ideal to ask the AI to write your tests for you at this time due to not having any implementation: the AI would need to make too many assumptions, and you run the risk of spending more time trying to prompt the AI than writing the test logic yourself. Where the AI co-pilot will become useful again in this process is in the analysis and optimization phase.

Keep in mind the following points when using AI to generate test code for you: 
- When doing TDD the AI will not have enough context in your code to reliably create test data for you at the start: when you've implemented your tested methods code generation will become more reliable 
- AI will typically provide better code when it works on individual parts of the code at a time (first write the test methods, then create the setup method, etc) 
- keep in mind many IDEs have test generation features: it may be faster to use these features and let your AI assist with auxiliary setup instead 
- Remember that just because the AI CAN provide fully built tests does not mean these tests are going to meet your application requirements

## Code Analysis
AI tools are usually good at explaining what pre-written code is doing. Take the following create method:
```java
@Override
public Person create(Person person) {
    try (Connection connection = ConnectionUtil.getConnection()) {
        String sql = "INSERT INTO person VALUES (default, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getAge());
        statement.execute();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            person.setId(rs.getInt(1));
            return person;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
```
You can ask your AI co-pilot to explain the code

Input:
```
explain what is happening in the following method:     
    @Override
    public Person create(Person person) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO person VALUES (default, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                person.setId(rs.getInt(1));
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
```
Output:
```
This method is an implementation of the create method in an overridden interface method.

Here's what's happening in the method:

1. It begins by obtaining a database connection using the ConnectionUtil.getConnection() method.

2. It then prepares an SQL statement to insert a new record into the person table. The statement includes    placeholders for the values to be inserted.

3. Next, it creates a PreparedStatement object with the SQL statement and the option to return generated keys (in this case, the auto-generated ID).

4. The method sets the values of the placeholders in the PreparedStatement object using the person object's properties (firstName, lastName, and age).

5. It executes the SQL statement using the execute() method on the PreparedStatement object.

6. After executing the statement, it retrieves the auto-generated keys using the getGeneratedKeys() method on the PreparedStatement object.

7. If there are any generated keys, it sets the ID of the person object to the first generated key and returns the person object.

8. If any exceptions occur during the execution or retrieval of the data, the method prints the stack trace of the exception.

9. Finally, if no person is created or an exception occurs, it returns null.

Let me know if you need help with anything else!
```
If using Codeium you can use the context provision syntax (@class-or-method-name) to give the AI context as well.

AI is pretty good at parsing code already created, but there are a few things to keep in mind: 
- Be specific with your questions when you can: context limits are increasing, but the more specific data you want the better chance you can get an in-depth response from the AI 
- If the AI goes off in the wrong direction or gives you incomplete data you are better off restarting the conversation than trying to course correct: AIs tend to fall into a "rut" and have a difficult time adjusting their solutions

## Code Optimization
Moving away from the Person code, consider the following fibonacci method:

```java
public static int fibonacciUnoptimized(int n) {
    if (n <= 1) {
        return n;
    } else {
        return fibonacciUnoptimized(n-1) + fibonacciUnoptimized(n-2);
    }
}
```
This will work, but optimized it is not (O(n^2)). We can ask our AI co-pilot to optimize the solution

Input:
```
Provide optimized versions of the following Java method: 
public static int fibonacciUnoptimized(int n) {     
    if (n <= 1) {         
        return n;     
    } else {         
        return fibonacciUnoptimized(n-1) + fibonacciUnoptimized(n-2);     
    } 
}
```
Output:
```
There are several ways to optimize the Fibonacci function. Here are a few options:

1. Memoization: Store the results of previously calculated Fibonacci numbers in an array or map to avoid redundant calculations. This can significantly reduce the number of recursive calls.
public static int fibonacciMemoization(int n) {
    int[] memo = new int[n + 1];
    return fibonacciMemoizationHelper(n, memo);
}

private static int fibonacciMemoizationHelper(int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] != 0) {
        return memo[n];
    }
    memo[n] = fibonacciMemoizationHelper(n - 1, memo) + fibonacciMemoizationHelper(n - 2, memo);
    return memo[n];
}
2. Bottom-up approach: Calculate Fibonacci numbers iteratively from the bottom up, starting from the base cases. This avoids recursion entirely and can be more efficient for large values of n.
public static int fibonacciBottomUp(int n) {
    if (n <= 1) {
        return n;
    }
    int[] fib = new int[n + 1];
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i <= n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
    return fib[n];
}
3. Optimized space complexity: If you only need to calculate the nth Fibonacci number, you can optimize the space complexity by only storing the last two Fibonacci numbers instead of the entire sequence.
public static int fibonacciOptimized(int n) {
    if (n <= 1) {
        return n;
    }
    int prev = 0;
    int curr = 1;
    for (int i = 2; i <= n; i++) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }
    return curr;
}
```
Notice how the AI recognizes the term "optimize" doesn't have a single solution: depending on your use case there are many ways code can be "optimal".

Keep in mind the following points when using AI to optimize your code:
- know what you mean by optimize 
    - optimize readability 
    - optimize time complexity 
    - etc 
- have an idea of what your code is doing before you try any optimization 
- check with your team before optimizing code to make sure there wasn't a specific reason for the current implementation

## Code Documentation
take the following Connection Utility class:
```java
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static String url = System.getenv("url");
    private static String username = System.getenv("username");
    private static String password = System.getenv("password");
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
}
```
there are multiple ways you could document what this class does: the simplest is to add a docstring for the getConnection method (note that you will need to use whatever means of providing code context your AI needs: Codeium can do so directly in the chat)

Input: ```Generate docstring for function: @getConnection```

Output:
```java
    /**
     * Retrieves a connection to the database.
     *
     * @return          the connection object
     * @throws SQLException if there is an error connecting to the database
     */
```
This can easily be added to the code and provides a succinct description of what the method does. Another option is to have the AI add comments to the code to explain what the different features are doing. We can use a previous example and have the AI add comments to explain what each line is doing.

Initial code:
```java
@Override
public Person create(Person person) {
    try (Connection connection = ConnectionUtil.getConnection()) {
        String sql = "INSERT INTO person VALUES (default, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getAge());
        statement.execute();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            person.setId(rs.getInt(1));
            return person;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
```
Input: ```Refactor function @create. Verbosely comment this code so that I can understand what's going on.```

Output:
```java
@Override
public Person create(Person person) {
    try (Connection connection = ConnectionUtil.getConnection()) { // Establish a connection to the database
        String sql = "INSERT INTO person VALUES (default, ?, ?, ?)"; // Define the SQL query to insert a new person
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Create a prepared statement with the SQL query
        statement.setString(1, person.getFirstName()); // Set the first parameter of the SQL query to the person's first name
        statement.setString(2, person.getLastName()); // Set the second parameter of the SQL query to the person's last name
        statement.setInt(3, person.getAge()); // Set the third parameter of the SQL query to the person's age
        statement.execute(); // Execute the SQL query
        ResultSet rs = statement.getGeneratedKeys(); // Get the generated keys (auto-incremented primary key values)
        if (rs.next()){
            person.setId(rs.getInt(1)); // Set the person's ID to the generated primary key value
            return person; // Return the updated person object
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print the stack trace if an SQL exception occurs
    }
    return null; // Return null if the person creation fails
}
```
This is an area where AI really shines: you should consistently see reliable results when using AI to generate documentation, the exception to this is if you are asking for documentation on a language the AI was not trained on or if the AI is in the middle of hallucinating in your current conversation.