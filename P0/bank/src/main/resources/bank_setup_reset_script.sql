-- added ';' to end of all comments to prevent malformed SQL statements;
-- add the "if exists" key words to your drop statement if you want to avoid having an SQLExecption
-- thrown if the table does not exist;
drop table if exists "user";

-- to simplify things it helps to have your table name and column names match your
-- Java entity data as closely as possible;
create table "user"(
	username text,
	password text
);

insert into "user" values ('admin', 1234);