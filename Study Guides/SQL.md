# SQL
Structured Query Language is tool for interacting with relational databases. It allows you to create tables, manipulate them, create user rolls, and create some functionality in the database.

## Schema
In SQL, a schema is a collection of database objects such as tables, stored procedures, indexes, views, and other entities that define the structure and organization of a database. It’s a container for organizing and managing data within a database. Each schema has an owner, typically a database user, and it helps enhance security by allowing fine-grained control over access privileges to database objects

## Sub Languages
These are the five sub languages off SQL, and some of their key words (these examples are from a Postgres database, see Week 2 day 1 notes for SQLite examples)
### Data Definition Language (DDL)
```sql
--these are the commands that let us set up and alter tables within our database

--create allows us to make new tables. We define the columns and their types inside parenthesis
create table simple_table(
	first_name varchar(50),
	last_name varchar(50)
);

--alter lets us make changes to tables and their columns
alter table simple_table add column person_id serial;

--truncate will remove all the data within a table without deleting the table itself, as long as their are no constraint issues
truncate table simple_table;

--drop will delete a table and its data, as long as their are no constraint issues
drop table simple_table;

--these commands are not reversible: there is no option to do a rollback
```
### Data Manipulation Language (DML)
```sql
--these are the CRUD operations (Create, Read, Update, Delete)

--insert is used to add data into a table
insert into names values(default, 'Billy', 'Bob');

--update is used to change data in a table
update names set first_name = 'Sally' where person_id = 1;

--select is used to get data from a table. This is sometimes categorized under DQL
select * from names where person_id = 1;

--delete is used to remove data from a table
delete from names where person_id = 1;
```
### Data Control Language (DCL)
```sql
--these commands manage users and privileges on the database

--this creates a basic user with the name test with password test. Useful for allowing limited access
CREATE ROLE test NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN PASSWORD 'test';

--this allows anyone who logs in as test to perform all actions on the given table
GRANT ALL ON TABLE practice.names TO test;

--this removes all rights to perform actions on the table from test user
REVOKE ALL ON TABLE practice.names FROM test;
```
### Transaction Control Language (TCL)
```sql
--these commands can start, end, and rollback transactions. Use them if you want fine control over your queries that
-- manipulate your tables (DML statements)

--this starts a new transaction
begin;
	insert into names values(default, 'Teddy', 'Vale');
    --this creates a spot we can rollback to if needed
	savepoint my_savepoint;
	insert into names values(default, 'Maddy', 'Mase');
    --this will rollback the transaction to the save point, so we lose the Sherri info
	rollback to savepoint my_savepoint;
    --this removes the savepoint, good practice
	release savepoint my_savepoint;
--this will commit the transaction, can also use end
commit; -- or end
```

## Joins
Joins allow you to combine table data by putting their columns next to each other
```sql
create table team(
	team_id serial primary key,
	team_name varchar(50)
);

create table player(
	player_id serial primary key,
	team_id int,
	player_name varchar(50),
	-- below is a variant option for creating a foreign key
	constraint team_fk foreign key(team_id) references team(team_id)
);
-- this will return the data ordered by what team the player is on. It will match the player to their team
select * from player join team on team.team_id = player.team_id order by player.team_id ;
```
if you just use the join keyword it defaults to an "inner" join, only records that have matching data determined by your on statement will be returned in the result set. You can also perform "left", "right", and "full" joins
```sql
-- this left join returns all data in the team (left) table and any matching records in the player table
select * from team left join player on team.team_id = player.team_id ;

-- this right join returns all the data in the player(right) table and any matching records in the team table
select * from team right join player on team.team_id = player.team_id ;

-- this full outer join returns all data in both the team and player tables
select * from team full outer join player on team.team_id = player.team_id ;

-- any records that don't have a match for data will still display, but their data will be set to null
```

## Functions
There are two kinds of functions in SQL: aggregate and scalar. Aggregate functions work on groups of data, whereas scalar functions work on single pieces of data.

Some common Aggregate functions:
```sql
-- sum(): returns the sum of values in a group of data
select sum(person_id) from names;
-- min(): returns the smallest value in group of data
select min(person_id) from names;
-- max(): returns the largest value in a group of data
select max(person_id) from names;
-- count(): returns the number of rows of data in the group
select count(person_id) from names;
-- avg(): returns the average in a group of data
select avg(person_id) from names;
```

some common scalar functions:
```sql
--now(): returns the current date and time
select now();
--upper(): returns the string value in all uppercase
select upper(first_name) from names where person_id = 1; 
--lower(): returns the string value in all lowercase
select lower(first_name) from names where person_id = 1;
--length(): returns the length of the value
select length(first_name) from names where person_id = 1;
--round(): takes two arguments, the first is the value to round, the second optional one is the acceptable number of decimal places
select round(person_id, 2) from names where first_name = 'Teddy';
```