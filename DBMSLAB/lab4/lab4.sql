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
  end_dt_time datetime,
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

create table if not exists PROCEDURES(
    code int(10) PRIMARY KEY,
    name_pro varchar(50),
    cost int(10)
);

create table if not exists TRAINED_IN(
    physician int(10) NOT NULL,
    treatment int(10) NOT NULL,
    certification date NOT NULL,
    certificationexp date NOT NULL,
    FOREIGN KEY(physician) REFERENCES PHYSICIAN(employeeid),
    FOREIGN KEY(treatment) REFERENCES PROCEDURES(code),
    PRIMARY KEY(physician,treatment)
);

create table if not exists UNDERGOES(
    patient int(10),
    procedures int(10),
    -- stay int(10),
    date datetime,
    physician int(10),
    assistingnurse int(10),
    FOREIGN KEY(patient) REFERENCES PATIENT(ssn),
    FOREIGN KEY(procedures) REFERENCES PROCEDURES(code),
    FOREIGN KEY(physician) REFERENCES PHYSICIAN(employeeid),
    FOREIGN KEY(assistingnurse) REFERENCES NURSE(employeeid),
    PRIMARY KEY(patient,procedures,date)
);
desc PHYSICIAN;
desc DEPARTMENT;
desc PATIENT;
desc NURSE;
desc APPOINTMENT;
desc BLOCK;
desc ROOM;
desc PROCEDURES;
desc TRAINED_IN;
desc UNDERGOES;

INSERT INTO NURSE values(101,'Carla Espinosa','Head Nurse',true,111111110);
INSERT INTO NURSE values(102,'Laverne Roberts','Nurse',true,222222220);
INSERT INTO NURSE values(103,'Paul Flowers','Head Nurse',true,333333330);

INSERT INTO PHYSICIAN values(1,'John Dorian','Staff Internist',111111110);
INSERT INTO PHYSICIAN values(2,'Elliot Reid','Attending Physician',222222220);
INSERT INTO PHYSICIAN values(3,'Christopher Turk','Surgical Attending Physician',333333333);
INSERT INTO PHYSICIAN values(4,'Percival Cox','Senior Attending Physician',444444444);
INSERT INTO PHYSICIAN values(5,'Bob Kelso','Head Chief of Medicine',555555555);
INSERT INTO PHYSICIAN values(6,'Todd Quinlan','Surgical Attending Physician',666666666);
INSERT INTO PHYSICIAN values(7,'John Wen','Surgical Attending Physician',777777777);
INSERT INTO PHYSICIAN values(8,'Keith Dudemeister','MD Resident',888888888);
INSERT INTO PHYSICIAN values(9,'Molly Clock','Attending Psychiatrist',999999999);

INSERT INTO DEPARTMENT values(1,'General Medicine',4);
INSERT INTO DEPARTMENT values(2,'Surgery',7);
INSERT INTO DEPARTMENT values(3,'Psychiatry',9);

insert into PATIENT values(100000001,'John Smith','42 Foobar Lane','555-0256',68476213,1);
insert into PATIENT values(100000002,'Grace Ritchie','37 Snafu Drive','555-0512',36546321,2);
insert into PATIENT values(100000003,'Random J. Patient','101 Omgbbq Street','555-1204',65465421,2);
insert into PATIENT values(100000004,'Dennis Doe','1100 Foobaz Avenue','555-2048',68421879,3);


insert into APPOINTMENT values (13216584,100000001,101,1,'2008-04-24 10:00:00','2008-04-24 11:00:00','A');
insert into APPOINTMENT values (59871321,100000004,102,4,'2008-04-26 10:00:00','2008-04-26 11:00:00','C');
insert into APPOINTMENT values (69879231,100000003,103,2,'2008-04-26 11:00:00','2008-04-26 12:00:00','C');
insert into APPOINTMENT values (76983231,100000001,104,3,'2008-04-26 12:00:00','2008-04-26 13:00:00','C');

INSERT INTO BLOCK values(1,1);
INSERT INTO BLOCK values(1,2);
INSERT INTO BLOCK values(2,1);
INSERT INTO BLOCK values(2,2);
INSERT INTO BLOCK values(3,1);
INSERT INTO BLOCK values(3,2);

insert into ROOM values(101,'Single',1,1,false);
insert into ROOM values(102,'Single',2,1,false);
insert into ROOM values(212,'Single',3,2,false);

insert into PROCEDURES values(1,'Reverse Rhinopodoplasty',1500);
insert into PROCEDURES values(2,'Obtuse Pyloric Recombobulation',3750);
insert into PROCEDURES values(3,'Folded Demiophtalmectomy',4500);
insert into PROCEDURES values(4,'Complete Walletectomy',10000);
insert into PROCEDURES values(5,'Obfuscated Dermogastrotomy',4899);

insert into UNDERGOES values(100000001,1,'2008-05-02 00:00:00',3,101);
insert into UNDERGOES values(100000001,3,'2008-05-10 00:00:00',7,101);
insert into UNDERGOES values(100000004,4,'2008-05-13 00:00:00',3,103);

insert into TRAINED_IN values(3,1,'2008-01-01','2008-12-31');
insert into TRAINED_IN values(3,2,'2008-01-01','2008-12-31');
insert into TRAINED_IN values(6,2,'2008-01-01','2008-12-31');
insert into TRAINED_IN values(6,5,'2007-01-01','2007-12-31');
insert into TRAINED_IN values(7,1,'2008-01-01','2008-12-31');


select * from PHYSICIAN;
select * from DEPARTMENT;
select * from PATIENT;
select * from NURSE;
select * from APPOINTMENT;
select * from BLOCK;
select * from ROOM;
select * from PROCEDURES;
select * from TRAINED_IN;
select * from UNDERGOES;
select * from UNDERGOES;
select * from TRAINED_IN;