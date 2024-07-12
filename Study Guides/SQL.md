# SQL
Structured Query Language is tool for interacting with relational databases. It allows you to create tables, manipulate them, create user rolls, and create some functionality in the database.

## Schema
In SQL, a schema is a collection of database objects such as tables, stored procedures, indexes, views, and other entities that define the structure and organization of a database. It’s a container for organizing and managing data within a database. Each schema has an owner, typically a database user, and it helps enhance security by allowing fine-grained control over access privileges to database objects

## Sub Languages
These are the five sub languages off SQL, and some of their key words (these examples are from a Postgres database)
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
NOTE: many people classify the fifth sub language, Data Query Language, as a subset of DML
```sql
--these are the CRUD operations (Create, Read, Update, Delete)

--insert is used to add data into a table
insert into names values(default, 'Billy', 'Bob');

--update is used to change data in a table
update names set first_name = 'Sally' where person_id = 1;

--select is used to get data from a table. This is sometimes categorized under DQL separately from DML
select * from names where person_id = 1;

--delete is used to remove data from a table
delete from names where person_id = 1;
```
### Data Query Language
```sql
--select is used to get data from a table. This is sometimes categorized under DQL separately from DML
select * from names where person_id = 1;

-- join and set operations fall under DQL
select * from players join teams on players.team_id = teams.team_id;

select team_id from teams union select team_id from players;
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
## Constraints
Constraints are used to limit or identify data within your tables. You should know these:
- PRIMARY KEY: makes the column an identifier. Combination of unique and not null
    - multiple primary keys are called composite keys
    - columns that could work as primary keys are called candidate keys
- FOREIGN KEY: makes the column reference a primary key on another table
- NOT NULL: column must have a value
- UNIQUE: column value must be different from all others in table
- CHECK: use when you need to ensure a condition is met (number > 0, for instance)
- DEFAULT: lets you create a default value. Also used with serial data type
```sql
create table names(
    -- this is now required to be not null and unique
	person_id serial primary key,
	first_name varchar(10),
	last_name varchar(10)
);

create table foreign_key_example(
	foreign_key_example_id serial,
	foreign_key int,
    --this makes it so our foreign_key column references the person_id column. Any entries to this table MUST reference someone on the names table
	constraint my_foreign_key foreign key(foreign_key) references names(person_id)
);
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

Some common scalar functions:
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

## Referential Integrity
This is the idea that we should have no orphaned records. If an entry has a foreign key, it NEEDS to reference an existing record. If the primary record is deleted then the foreign record needs to have a response. This response could be to self delete, or even to stop the parent record from being deleted. You have a few common options:
- on delete cascade: deletes the data that has a foreign relationship to the primary data
- on delete restrict: prevents the primary data from being deleted
- on delete update: allow the foreign key to update, but if it breaks referential integrity the whole transaction will fail

## Multiplicity
This describes the relationship between tables. There are three ways tables can relate:
- one-to-one: only one entity in a table references another
```sql
create table person(
	person_id serial primary key
);

create table brain(
	brain_id serial primary key,
	person_id int unique, --notice the unique constraint: only one brain can be attached to a person
	constraint brain_fk foreign key (person_id) references person(person_id)
);
```
- one-to-many (or many-to-one): many entities in a table can reference one other entity in the other table
```sql
create table team(
	team_id serial primary key
);

create table player(
	player_id serial primary key,
	team_id int, --many players can have the same team id, since they play on the same team
	constraint player_fk foreign key(team_id) references team(team_id)
);
```
- many-to-many: many entities in a table can reference many other entities in another table. Because a direct link can not be established between the two (think teachers and students: many teachers can have many students, and many students can have many teachers) you need to create a junction table (sometimes called a join table).
```sql
create table teacher(
	teacher_id serial primary key
);

create table student(
	student_id serial primary key
);
--notice there are no foreign keys in the student or teacher tables: their relationship is handled by the junction table classroom
create table classroom(
	classroom_id serial primary key,
	teacher_id int,
	student_id int,
	constraint teacher_fk foreign key(teacher_id) references teacher(teacher_id),
	constraint student_fk foreign key(student_id) references student(student_id)
);
```
## Normalization
Normalization is simply a standardized way of organizing data in tables. Higher and/or lower levels of "normalization" are not inherently better or worse than each other: they are simply a way of organizing data that follow a standard format. There are three levels of normalization to be familiar with for training, and each increment includes all the previous requirements:
- 1st normal form
    - primary key is present
        - composite key is allowed
    - each column contains only one value (called an atomic value)
        - column "first_name" is valid for first normal form, it contains only one value
        - column "first_and_last_name" is not valid for first normal form, since the column is not atomic
- 2nd normal form
    - non-key columns depend on primary key
        - if using a composite key then non key columns must depend on all keys
- 3rd normal form
    - no transitive columns
        - valid:
            - columns product_cost and product_purchased
        - invalid:
            - columns product_cost and product_purchased and total_cost
                - total_cost could be calculated by product_cost and _product_purchased, which makes it transitive
## ACID
Any DML actions before a commit are called transactions: Every transaction should have the ACID properties (this is managed by the database, and different types of databases will handle implementing ACID in their own way):

Atomicity
- all transactions must succeed for a commit to happen. If any fail, there is no commit

Consistency
- all transactions must enforce existing constraints

Isolation
- multiple concurrent transactions should not interfere with one another

Durability
- committed transactions should be persisted, even if there is some catastrophic failure (power outage, system, crash, etc). 

## Read Phenomena
These three read phenomena are problematic kinds of interactions with your tables (they can happen if there are multiple connections to the database at the same time); isolation levels are used to deal with them:
- Dirty Read: reading data that is uncommitted
- Non-repeatable read: when a row is read twice in a transaction and the values are different
- Phantom Read: reading data that is being added or modified by a running transaction

## Isolation Levels
These help prevent the various read phenomena (these levels are managed by the database you are using)
- Read Uncommitted
	- This is bad, don't do this
	- dirty reads are common at this level
	- data is inconsistently: you don't know if you are reading committed data or not
- Read Committed
	- default for Postgres and Oracle
	- Only committed data can be seen by other transactions
	- Prevents dirty reads, but not phantom reads
	- locks the row in the transaction from being selected by other transactions
- Repeatable Read
	- not common
	- read and write locks
	- still allows phantom reads, but not non-repeatable reads
- Serializable
	- locks read, write, and range (essentially locks down the data part of the transaction)
	- prevents phantom reads
	- tables being read cannot be interacted with until the transactions are committed
## Joins
Joins allow you to combine table data by putting their columns next to each other to view
inner
```sql
create table team(
	team_id serial primary key,
	team_name varchar(50)
);

create table player(
	player_id serial primary key,
	team_id int,
	player_name varchar(50),
	constraint team_fk foreign key(team_id) references team(team_id)
);
-- this will return the data ordered by what team the player is on. It will match the player to their team
select * from player inner join team on team.team_id = player.team_id order by player.team_id ;

```
the outer joins are left, full outer, and right join
```sql
-- this left join returns all data in the team (left) table and any matching records in the player table
select * from team left join player on team.team_id = player.team_id ;

-- this right join returns all the data in the player(right) table and any matching records in the team table
select * from team right join player on team.team_id = player.team_id ;

-- this full outer join returns all data in both the team and player tables
select * from team full outer join player on team.team_id = player.team_id ;

```
think of the cross join as showing possibility (cartesian product)
```sql
--all players will be matched with all teams
select * from team cross join player ;
```
the natural join combines columns with the same name, quick and easy
```sql
--this will return the tables together, but the team_id columns will be combined
select * from team natural join player ;
```
self joins match columns in the same database, used for hierarchy.
## Set Operations
sets allow you to stack tables on top of each other. Requires columns with compatible data types 

unions combine like columns and return one table that is a combined product
```sql
-- returns all id values without any duplicates (make union all to allow duplicates)
select team.team_id from team union select player.team_id from player;
```
intersect only groups the elements that are common to the two tables
```sql
-- this will only return those team_ids that have a player assigned to them
select team_id from team intersect select team_id from player;