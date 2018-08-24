drop database company;
create database company;
use company;
create table if not exists EMPLOYEE (
	Fname varchar(50) NOT NULL,
	Minit varchar(2),
	Lname varchar(50),
	Ssn int(15) UNIQUE,
	Bdate date,
	Address varchar(100) NOT NULL,
	sex char NOT NULL,
	Salary int(10),
	Super_ssn int(15),
	Dno int(3) NOT NULL,
	PRIMARY KEY(Ssn)
);


create table if not exists DEPARTMENT (
	Dname varchar(50) NOT NULL,
	Dnumber int(3) NOT NULL,
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
	-- PRIMARY KEY(Dependent_name),
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
alter table DEPARTMENT add  FOREIGN KEY(Mgr_ssn) REFERENCES EMPLOYEE(Ssn);
desc EMPLOYEE;
desc DEPARTMENT;
desc PROJECT;
desc DEPENDENT;
desc DEPT_LOCATIONS;
desc WORKS_ON;


insert into EMPLOYEE values('John','B','Smith',123456789,'1965-01-09','731 Fondren,Houston,TX','M',30000,333445555,5);
insert into EMPLOYEE values('Franklin','T','Wong',333445555,'1955-12-08','638 Voss,Houston,TX','M',40000,888665555,5);
insert into EMPLOYEE values('Alicia','J','Zelaya',999887777,'1968-01-19','3321 Castle,Spring,TX','F',25000,987654321,4);
insert into EMPLOYEE values('Jennifer','S','Wallace',987654321,'1941-06-20','291 Berry,Bellaire,TX','F',43000,888665555,4);
insert into EMPLOYEE values('Ramesh','K','Narayan',666884444,'1962-09-15','975 Fire Oak,Humble,TX','M',38000,333445555,5);
insert into EMPLOYEE values('Joyce','A','English',453453453,'1972-07-31','5631 Rice,Houston,TX','F',25000,333445555,5);
insert into EMPLOYEE values('Ahmed','V','Jabber',987987987,'1969-03-29','980 Dallas,Houston,TX','M',25000,987654321,4);
insert into EMPLOYEE values('James','E','Brog',888665555,'1937-11-10','450 Stone,Houston,TX','M',55000,NULL,1);


insert into DEPARTMENT values('Research',5,333445555,'1988-05-22');
insert into DEPARTMENT values('Adminstration',4,987654321,'1995-01-01');
insert into DEPARTMENT values('Headquarters',1,888665555,'1981-06-19');


insert into DEPT_LOCATIONS values(1,'Houston');
insert into DEPT_LOCATIONS values(4,'Stafford');
insert into DEPT_LOCATIONS values(5,'Bellaire');
insert into DEPT_LOCATIONS values(5,'Sugerland');
insert into DEPT_LOCATIONS values(5,'Houston');


insert into PROJECT values('ProductX',1,'Bellaire',5);
insert into PROJECT values('ProductY',2,'Sugerland',5);
insert into PROJECT values('ProductZ',3,'Houston',5);
insert into PROJECT values('Computerization',10,'Stafford',4);
insert into PROJECT values('Reorganization',20,'Houston',1);
insert into PROJECT values('Newbenefits',30,'Stafford',4);



insert into WORKS_ON values(123456789,1,32.5);
insert into WORKS_ON values(123456789,2,7.5);
insert into WORKS_ON values(666884444,3,40.0);
insert into WORKS_ON values(453453453,1,20.0);
insert into WORKS_ON values(453453453,2,20.0);
insert into WORKS_ON values(333445555,2,10.0);
insert into WORKS_ON values(333445555,3,10.0);
insert into WORKS_ON values(333445555,10,10.0);
insert into WORKS_ON values(333445555,20,10.0);
insert into WORKS_ON values(999887777,30,30.0);
insert into WORKS_ON values(999887777,10,10.0);
insert into WORKS_ON values(987987987,10,35.0);
insert into WORKS_ON values(987987987,30,5.0);
insert into WORKS_ON values(987654321,30,20.0);
insert into WORKS_ON values(987654321,20,15.0);
insert into WORKS_ON values(888665555,20,NULL);



insert into DEPENDENT values(333445555,'Alice','F','1986-04-05','Daughter');
insert into DEPENDENT values(333445555,'Theodore','M','1983-10-25','Son');
insert into DEPENDENT values(333445555,'Joy','F','1958-05-03','Spouse');
insert into DEPENDENT values(987654321,'Abner','M','1942-02-28','Spouse');
insert into DEPENDENT values(123456789,'Michael','M','1988-01-04','Son');
insert into DEPENDENT values(123456789,'Alice','F','1988-12-30','Daughter');
insert into DEPENDENT values(123456789,'Elizabeth','F','1967-05-05','Spouse');
