drop database company;
create database company;
use company;
create table if not exists EMPLOYEE (
	Fname varchar(50) NOT NULL,
	Minit varchar(2),
	Lname varchar(50),
	Ssn int(15),
	Bdate date,
	Address varchar(100) NOT NULL,
	sex char NOT NULL,
	Salary int(10),
	Super_ssn int(15) UNIQUE,
	Dno int(2) NOT NULL,
	PRIMARY KEY(Ssn)
);


create table if not exists DEPARTMENT (
	Dname varchar(50) NOT NULL,
	Dnumber int(2) NOT NULL,
	Mgr_ssn int(15),
	Mgr_start_date date,
	PRIMARY KEY(Dnumber)
);


create table if not exists PROJECT (
	Pname varchar(50) NOT NULL,
	Pnumber int(3) NOT NULL,
	Plocation varchar(50) NOT NULL,
	Dnum int(3) NOT NULL,
	PRIMARY KEY(Pnumber),
	FOREIGN KEY(Dnum) REFERENCES DEPARTMENT(Dnumber)
);
create table if not exists DEPENDENT (
	Essn int(15),
	Dependent_name varchar(50) NOT NULL,
	Sex char NOT NULL,
	Bdate date NOT NULL,
	Relationship varchar(50) NOT NULL,	
	PRIMARY KEY(Dependent_name),
	FOREIGN KEY(Essn) REFERENCES EMPLOYEE(Ssn)
);
create table if not exists DEPT_LOCATIONS(
	Dnumber int(3),
	Dlocation varchar(50) NOT NULL,
	FOREIGN KEY(Dnumber) REFERENCES DEPARTMENT(Dnumber)
);
create table if not exists WORKS_ON(
	Essn int(15),
	Pno int(3),
	Hours decimal(4,2),
	FOREIGN KEY(Essn) REFERENCES EMPLOYEE(Ssn),
	FOREIGN KEY(Pno) REFERENCES PROJECT(Pnumber)
);
alter table DEPARTMENT add  FOREIGN KEY(Mgr_ssn) REFERENCES EMPLOYEE(Super_ssn);
desc EMPLOYEE;
desc DEPARTMENT;
desc PROJECT;
desc DEPENDENT;
desc DEPT_LOCATIONS;
desc WORKS_ON;
insert into EMPLOYEE values('John','B','Smith',123456789,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,5);
insert into EMPLOYEE values('Franklin','T','Wong',333445555,'1955-12-08','638 Voss,Houseton,TX','M',40000,888665555,5);
insert into EMPLOYEE values('Alicia','J','Zelaya',999887777,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,4);
insert into EMPLOYEE values('Jennifer','S','Wallace',987654321,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,4);
insert into EMPLOYEE values('Ramesh','K','Narayan',666884444,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,5);
insert into EMPLOYEE values('Joyce','A','English',453453453,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,5);
insert into EMPLOYEE values('Ahmed','V','Jabber',987987987,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,4);
insert into EMPLOYEE values('James','E','Brog',888665555,'1965-01-09','731 Fondren,Houseton,TX','M',30000,333445555,1);
