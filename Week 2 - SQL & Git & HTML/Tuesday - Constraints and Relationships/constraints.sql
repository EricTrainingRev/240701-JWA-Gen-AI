-- when creating tables we can apply "constraints" that limit or control what data we can
-- store inside of the table and the specific records the constraints are applied to
-- UNIQUE: only one record may hold whatever value is stored
-- NOT NULL: the column may not store a null value
-- PRIMARY KEY: this is a combination of UNIQUE and NOT NULL
-- DEFAULT: if no data is provided for the column, the given default is set

-- ON DELETE: used with foreign keys, if the parent record is deleted the ON DELETE constraint
--    		  tells the database what to do with the child record (the one with the foreign key)
-- ON UPDATE: same as ON DELETE, but for updating a record
-- CASCADE: used with ON DELETE, this tells your database to delete the assocaited record when the
--		    parent record is deleted
-- SET DEFAULT: used with ON DELETE, sets the foreign key to a default value you set
-- SET NULL: used with ON DELETE, sets the foreign key value to null
-- RESTRICT: used with ON DELETE, prevents the primary key referenced by your foreign key from
--		    being deleted

drop table people;
create table people(
	person_id integer primary key,
	person_name text not null,
	nickname text unique,
	age int default (0)
);

insert into people (person_name, nickname) values ('Billy Billington', 'Slagathor');

select * from people;