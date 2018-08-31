drop database hospital;
create database hospital;

use hospital;

create table if not exists PHYSICIAN (
  employeeid int(10) UNIQUE NOT NULL,
  name varchar(50) NOT NULL,
  position varchar(50),
  ssn int(10) NOT NULL,
  PRIMARY KEY(ssn)
);

create table if not exists DEPARTMENT (
  departmentid int(10) UNIQUE NOT NULL,
  name varchar(50) NOT NULL,
  head int(10) NOT NULL,
  FOREIGN KEY(head) REFERENCES PHYSICIAN(employeeid)
);

create table if not exists PATIENT (
  ssn int(10) PRIMARY KEY,
  name varchar(50) NOT NULL,
  address varchar(50) NOT NULL,
  phone varchar(20),
  insuranceid int(10),
  pcp int(10),
  FOREIGN KEY(pcp) REFERENCES PHYSICIAN(employeeid)
);

create table if not exists NURSE (
  employeeid int(10) PRIMARY KEY,
  name varchar(50) NOT NULL,
  position varchar(50),
  registered boolean,
  ssn int(10)
);

create table if not exists APPOINTMENT (
  appointmentid int(10) PRIMARY KEY,
  patient int(10),
  prepnurse int(10),
  physician int(10),
  start_dt_time datetime,
  end_dt_time datetime,]
  examinationroom char,
  FOREIGN KEY(patient) REFERENCES PATIENT(ssn),
  FOREIGN KEY(prepnurse) REFERENCES NURSE(employeeid),
  FOREIGN KEY(physician) REFERENCES PHYSICIAN(employeeid)
);

create table if not exists BLOCK (
  blockfloor int(10) NOT NULL,
  blockcode int(10) NOT NULL,
  PRIMARY KEY(blockfloor,blockcode)
);

create table if not exists ROOM (
  roomnumber int(10) PRIMARY KEY,
  roomtype varchar(10) NOT NULL,
  blockfloor int(10),
  blockcode int(10),
  unavailable boolean NOT NULL,
  FOREIGN KEY(blockfloor,blockcode) REFERENCES BLOCK(blockfloor,blockcode)
);


insert into APPOINTMENT values (13216584,100000001,101,1,'2008-04-24 10:00:00','2008-04-24 11:00:00','A');
insert into APPOINTMENT values (59871321,100000004,,4,'2008-04-26 10:00:00','2008-04-26 11:00:00','C');
insert into APPOINTMENT values (69879231,100000003,103,2,'2008-04-26 11:00:00','2008-04-26 12:00:00','C');
insert into APPOINTMENT values (76983231,100000001,,3,'2008-04-26 12:00:00','2008-04-26 13:00:00','C');


insert into ROOM values(101,'Single',1,1,false);
insert into ROOM values(102,'Single',2,1,false);
insert into ROOM values(212,'Single',3,2,false);

insert into PATIENT values(100000001,'John Smith','42 Foobar Lane','555-0256',68476213,1);
insert into PATIENT values(100000002,'Grace Ritchie','37 Snafu Drive','555-0512',36546321,2);
insert into PATIENT values(100000003,'Random J. Patient','101 Omgbbq Street','555-1204',65465421,2);
insert into PATIENT values(100000004,'Dennis Doe','1100 Foobaz Avenue','555-2048',68421879,3);
