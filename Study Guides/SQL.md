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
