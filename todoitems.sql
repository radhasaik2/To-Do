CREATE DATABASE todo_db;
USE todo_db;

create table todo_items (
    todoId int primary key auto_increment,
    currentDate date not null,
    todoDesc varchar(175) not null,
    targetDate datetime not null,
    todoStatus varchar(20) default 'PENDING',
    credited_by varchar(35) default 'admin',
    credited_date datetime default (now()),
    modified_by varchar(35) null,
    modified_date datetime default (now())
);

INSERT INTO todo_items (currentDate, todoDesc, targetDate, todoStatus, credited_by)
VALUES 
    (CURRENT_DATE, 'Complete project documentation', '2024-01-15 09-00-01', 'PENDING', 'admin'),
    (CURRENT_DATE, 'Review code changes', '2024-01-12 11-11-09', 'developer'),
    (CURRENT_DATE, 'Prepare meeting agenda', '2024-01-10 05-05-05', 'COMPLETE', 'manager');

INSERT INTO todo_items (currentDate, todoDesc, targetDate,credited_by)
VALUES(CURRENT_DATE, 'Review code changes', '2024-07-17 10-56-08', 'admin');

alter table todo_items
drop column user_id;

alter table todo_items
modify column todoStatus enum("PENDING","IN-PROGRESS","COMPLETE") default "PENDING";

alter table todo_items
add column userId int ,
add foreign key(userId) references user_auth(userId);

SELECT * FROM todo_items;

create table user_auth (
userId int primary key auto_increment,
username varchar(30) unique, 
userPassword varchar(10),
userFirstname varchar(10),
userLastname varchar(10)
);

insert into user_auth(username,userPassword,userFirstname,userLastname)
values("radha@05","password@0","radha","sai");

alter table user_auth
modify column userLastname varchar(10) null;

insert into user_auth(username,userPassword,userFirstname,userLastname)
values("sai@13","password","sai","");

select * from user_auth;
