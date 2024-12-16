create table movie_list (movie_id integer, movie_name char(500), movie_type char(100), is_watched integer, priority integer);

create table movie_properties(movie_id integer
, other_name char(500)
, description text
, movie_year integer
, movie_length integer
, poster_url char(1000)
, kp_raiting NUMERIC
, genres char(500));

create table movie_types (
mt_id integer,
mt_name varchar(100)
);

insert into movie_types (mt_id, mt_name) values (1, 'animated-series');
insert into movie_types (mt_id, mt_name) values (2, 'anime');
insert into movie_types (mt_id, mt_name) values (3, 'cartoon');
insert into movie_types (mt_id, mt_name) values (4, 'movie');
insert into movie_types (mt_id, mt_name) values (5, 'tv-series');

drop table movie_list;

drop table movie_properties;

select * from movie_list;

select * from movie_properties;

truncate table movie_list;

truncate table movie_properties;