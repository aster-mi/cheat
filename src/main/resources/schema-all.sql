drop table if exists cheat;

create table cheat (
id serial,
user_id integer NOT NULL,
tag_id integer,
title varchar(50),
code varchar(10000),
detail varchar(10000),
create_at timestamp default current_timestamp
);

drop table if exists tag;

create table tag (
id serial,
user_id integer NOT NULL,
name varchar(10),
color varchar(7),
create_at timestamp default current_timestamp
);

drop table if exists codeuser;

create table codeuser (
user_id serial,
username VARCHAR(64) NOT NULL,
password VARCHAR(128) NOT NULL,
create_at timestamp default current_timestamp
);

INSERT INTO codeuser(username, password) VALUES('hoge1', '$2a$08$NNW3SBlGCnZNdGWwF7VFOenilliysSPY8t0vMKMC1rulhDORvJFIO');
INSERT INTO codeuser(username, password) VALUES('hoge2', '$2a$08$NNW3SBlGCnZNdGWwF7VFOenilliysSPY8t0vMKMC1rulhDORvJFIO');