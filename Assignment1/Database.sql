create database users;
use users;
create table users(
id int primary key auto_increment,
name varchar(30),
email varchar(20),
password varchar(10)
);

insert into users(name,email,password) values("sai","sai10259@gmail.com","password");

select * from users;

create table ratings(
id int primary key auto_increment,
moviename varchar(30),
rating varchar(20)
);

insert into ratings(moviename,rating) values("og","excellent");

select * from ratings;
