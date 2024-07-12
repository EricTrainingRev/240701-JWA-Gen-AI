/*
 * The sql statement below will return all names from customers and employees, but it includes
 * an incredible amount of redundant data: it would be better to combine the columns
 * to prevent the excess of name information
 */
SELECT c.FirstName, c.LastName, e.FirstName, e.LastName FROM Customer c 
JOIN Employee e;

/*
 * We can create a union by using the UNION key word. This will take whatever is in your
 * first select statement and add the content of the second select statement (after the
 * union keyword) and return all the data inside of a single column for each column
 * requested in the initial select statement
 */
SELECT FirstName, LastName FROM Customer -- these columns selected determine the RESULT SET columns
UNION
SELECT FirstName, LastName FROM Employee; -- this DATA IS added TO the columns requested IN the FIRST SELECT statement

/*
 * As long as the data types of the columns are compatable you can perform a union operation
 * on the data
 */
SELECT Company FROM Customer
UNION -- this unites UNIQUE values
SELECT Title FROM Employee;

SELECT CustomerId FROM Customer c 
UNION ALL -- this unites ALL values
SELECT EmployeeId FROM Employee e
ORDER BY CustomerId desc;