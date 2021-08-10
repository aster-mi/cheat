drop table if exists cheat;

create table cheat (
id serial,
title varchar(50),
code varchar(10000),
detail varchar(10000),
create_at timestamp default current_timestamp
);
insert into cheat(title, code, detail)values('人間作成','new Human();','人間のinstanceを生成する');
insert into cheat(title, code, detail)values('var','//varの使い方'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";'||chr(13)||chr(10)||'var x = "文字列";','右辺の型をもとにvarで省略できる');
insert into cheat(title, code, detail)values('bootstrap','btn','久々でむずかしい。');