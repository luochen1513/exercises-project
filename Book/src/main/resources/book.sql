use book;
drop table user;
create table user(
    userId integer primary key auto_increment,
    username varchar(20) unique ,
    password varchar(200),
    sex varchar(20),
    email varchar(50) unique,
    phone varchar(11) unique
);
drop table book;
create table book(
    bookId integer primary key auto_increment,
    name varchar(200),
    score varchar(200),
    price varchar(200),
    publish varchar(200),
    url varchar(200)
);
drop table hit;
create table hit(
    hitId integer primary key auto_increment,
    userId integer,
    bookId integer,
    hit integer default 0
);
create table user_book(
    id integer primary key auto_increment,
    userId integer,
    bookId integer
);
use echarts;