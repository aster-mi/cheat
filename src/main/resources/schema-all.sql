drop table if exists cheat;

create table cheat (
id serial,
title varchar(30),
code varchar(500),
detail varchar(1000),
create_at timestamp default current_timestamp
);