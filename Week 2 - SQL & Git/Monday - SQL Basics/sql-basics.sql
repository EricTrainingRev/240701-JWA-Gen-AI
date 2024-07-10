-- anything after 2 dashes is considered a comment on the same line

-- To get started, first we need to create a table to store information


-- to delete a table from the database use the drop table command
drop table people;

-- the initials statement "create table people" sets the name of the table to "people"
create table people(
	-- this sets the first column of the table to have the name "age" and the type int
	age int,
	-- this sets the second column of the table to have the name "name" and the type text
	name text
);

-- if we want to edit our table after creating it we can alter content as needed
-- here we remove the name column
alter table people drop column name;

-- here we re-add the name column but declare a different (but related) data type
alter table people add column name varchar;

-- When interacting with our database content we typically are performing one of four actions:
-- Creating
-- Reading
-- Updating
-- Deleting



-- CREATING
-- this is how to add a record to a table with all column data being set
insert into people values (30,'Billy');

-- this is how add a partial record to the table
insert into people (age) values (50);
insert into people (name) values ('Sally');

-- you can swap the order of entry you provide data
insert into people (name, age) values ('Teddy', 123);

-- READING
-- the select keyword is used to get information from your database
-- use a '*' character if you want all the data from a table
select * from people;

-- if you want specific information you can indicate what columns of data you want returned
select name from people;
select age from people;

-- if you need to filter the information returned in the result set you can use the
-- 'where' keyword and provide a filter
select * from people where name = 'Teddy';
select * from people where age < 50;
-- % used for 0 or more characters, _ wildcard for a single character
select * from people where name like 'S%';

-- UPDATING
-- to update one or more records we use the 'update' keyword
update people set name = 'Miranda' where age = 50;
update people set age = 32 where name = 'Sally';

-- you can do batch updating as well, this will update all records in your table
update people set age = 24;

-- DELETING
-- to delete data from a table you use the 'delete' keyword
delete from people where age = 24;























