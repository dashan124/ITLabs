drop database insurance;
create database insurance;

use insurance;

create table if not exists person(
driver_id char(4) PRIMARY KEY,
name varchar(30),
address varchar(30)
);

create table car(
reg_no char(15) PRIMARY KEY,
model char(20),
year number(4)
);

create table accident(
report_no int PRIMARY KEY,
acc_date date,
location varchar(30)
);

create table owns(
driver_id char(4),
reg_no char(15),
FOREIGN KEY driver_id REFERENCES person,
FOREIGN KEY reg_no REFERENCES car
);

create table participated( 
driver_id char(4),
reg_no char(15),
FOREIGN KEY driver_id REFERENCES person,
FOREIGN KEY reg_no REFERENCES car,
FOREIGN KEY report_no REFERENCES accident,
damage_amt number(10,2) PRIMARY KEY
);