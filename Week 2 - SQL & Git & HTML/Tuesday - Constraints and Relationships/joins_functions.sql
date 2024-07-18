-- any mildly complex join query can easily become very large and difficult to read. We can make
-- use of aliases for both column names and table references to make the query more readable.

SELECT 
	-- using the AS keyword we can set a new name for the column, can be done for non join queries as well
	t.name AS 'song', 
	a.AlbumId, 
	a.Title AS 'album title', 
	ar.name 'artist', 
	g.name AS 'genre'
FROM track t -- track t sets "t" as an alias for the table, we can use this alias anywhere in the query, even before declaring it
JOIN album a ON t.AlbumId = a.AlbumId -- joining via a FK and PK is common, but only matching data types is required
JOIN artist ar ON a.ArtistId = ar.ArtistId
JOIN genre g ON t.GenreId = g.GenreId;

-- you can also join a table to itself: this returns employee and manager data (in a single record) for each employee that reports to the Sales Manager
SELECT 
	-- all this data comes from the same table, but by using a join we can place the data next to each other in a single result set
	e.FirstName AS 'Employee First Name', 
	e.LastName AS 'Employee Last Name', 
	e.Title AS 'Employee Title',
	m.FirstName AS 'Manager First Name',
	m.LastName AS 'Manager Last Name',
	m.Title AS 'Manager Title'
FROM Employee e
JOIN Employee m ON e.ReportsTo = m.EmployeeId -- the Chinook database employee table has a ReportsTo column that is a FK to the employee EmployeeId column
WHERE m.Title = 'Sales Manager';

-- a common feature to use alongside joins is aggregate functions: these functions take in multiple rows worth of data and combine them in some way
-- the example below returns the sum of all sales each employee was involved with
-- upper and lower are examples of scalar functions: they perform an action on each individual column as opposed to combining the data
SELECT sum(i.Total),upper(e.FirstName), lower(e.LastName)  FROM invoice i
JOIN Customer c ON i.CustomerId = c.CustomerId 
JOIN Employee e ON c.SupportRepId = e.EmployeeId
-- GROUP BY is how you determine what data needs to be aggregated, otherwise the database does not know how to order the aggregated data
GROUP BY e.EmployeeId -- this tells the database to get the sum of all totals associated with each EmployeeId, found in the employee table
-- if you want to further filter the results returned, like if you had used a "where" statement, you
-- need to use the "having" keyword when an aggregate function has been used
HAVING sum(i.Total) > 730 -- only results with a total sum greater than 730 will be in the result set
ORDER BY e.LastName ; -- you can provide instruction for how to order the result set, ASC is default, DESC can be selected
	
	
	
	
	
	
	
	
	