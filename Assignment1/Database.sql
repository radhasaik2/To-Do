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


-- Create movies table
create table movies (
    movieid int primary key auto_increment,
    title varchar(100) not null,
    description text,
    release_year int
);

insert into movies (title, narration, release_year) values
('The Dark Knight', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 2008);

-- Create ratings table
create table ratings (
ratingid int primary key auto_increment,
userid int not null,
movieid int not null,
rating int not null check(rating between 1 and 5),
created_at date default (current_date()),
foreign key (userid) references users(userid),
foreign key (movieid) references movies(movieid)
);

select * from ratings;
