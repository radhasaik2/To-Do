create database users;
use users;

-- new user table
create table users(
userid int primary key auto_increment,
name varchar(30) not null unique,
email varchar(20) not null unique,
password varchar(10) not null
);

insert into users(name,email,password) values("sai","sai0259@gmail.com","password");

select * from users;

alter table users modify password varchar(60);
alter table users modify email varchar(60);
