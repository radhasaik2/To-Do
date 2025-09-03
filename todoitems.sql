create database todoitems;
use todoitems;
create table todoitems (
todoId int primary key,
currentDate datetime,
todoDesc varchar(150),
targetDate datetime,
todoStatus varchar(20) default "PENDING"
);

insert into todoitems (currentDate,todoDesc,targetDate)
values
("2025-09-01 01-45-00","create a database","2025-09-02 05-30-00"),
("2025-09-01 01-45-00","creating dao and dto","2025-09-03 01-00-00"),
("2025-09-01 01-45-00","trying to execute the servlet project","2025-09-03 02-45-00");

-- alter table todoitems
-- modify column todoStatus enum("PENDING","IN_PROGRESS","COMPLETE") default "PENDING";

-- insert into todoitems value(104,"2025-09-01 01-45-00","create a database","2025-09-02 05-30-00","IN_PROGRESS");
-- insert into todoitems value(105,"2025-09-01 01-45-00","create a database","2025-09-02 05-30-00","COMPLETE");

delete from todoitems where todoId=104;

alter table todoitems
modify column todoStatus enum("PENDING","IN-PROGRESS","COMPLETE") default "PENDING";

insert into todoitems value(104,"2025-09-01 01-45-00","create a database","2025-09-02 05-30-00","IN-PROGRESS");

alter table todoitems
modify column todoId int auto_increment;

alter table todoitems
add column credited_by varchar(20) default "admin",
add column credited_date date default "2025-09-01",
add column modified_by varchar(20) null,
add column modified_date datetime default "2025-09-01 07-00-00";

select * from todoitems;


