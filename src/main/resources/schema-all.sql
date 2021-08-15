drop table if exists cheat;

create table cheat (
id serial,
user_id integer,
title varchar(50),
code varchar(10000),
detail varchar(10000),
create_at timestamp default current_timestamp
);

drop table if exists tag;

create table tag (
id serial,
user_id integer,
name varchar(10),
color varchar(7),
create_at timestamp default current_timestamp
);