-- 1 query without join method
select Fname,Minit,Lname,Bdate,Address from EMPLOYEE,DEPARTMENT where EMPLOYEE.Dno=DEPARTMENT.Dnumber and DEPARTMENT.Dname='Adminstration';
-- 1 query with join method

select EMPLOYEE.Fname,EMPLOYEE.Minit,EMPLOYEE.Lname,EMPLOYEE.Bdate,EMPLOYEE.Address from EMPLOYEE
inner join DEPARTMENT on EMPLOYEE.Dno=DEPARTMENT.Dnumber and DEPARTMENT.Dname='Adminstration';

-- 2 Query without join

select SUM(EMPLOYEE.salary),MIN(EMPLOYEE.salary),MAX(EMPLOYEE.salary),AVG(EMPLOYEE.salary)
from EMPLOYEE,DEPARTMENT where EMPLOYEE.Dno=DEPARTMENT.Dnumber and DEPARTMENT.Dname='Research';

-- 2 Query with inner join

select SUM(EMPLOYEE.salary),MIN(EMPLOYEE.salary),MAX(EMPLOYEE.salary),AVG(EMPLOYEE.salary)
from EMPLOYEE
inner join DEPARTMENT on EMPLOYEE.Dno=DEPARTMENT.Dnumber and DEPARTMENT.Dname='Research';

-- 3 Count no of employees
--  without using join

select COUNT(EMPLOYEE.Fname) from EMPLOYEE,DEPARTMENT where EMPLOYEE.Dno=DEPARTMENT.Dnumber and DEPARTMENT.Dname='Adminstration';

-- with inner join

select COUNT(EMPLOYEE.Fname) from EMPLOYEE
inner join DEPARTMENT on EMPLOYEE.Dno=DEPARTMENT.Dnumber and DEPARTMENT.Dname='Adminstration';

-- 4 group by

select  Pname,Pnumber,COUNT(Essn) as employees_no from WORKS_ON,PROJECT where PROJECT.Pnumber=WORKS_ON.Pno group by Pno,Pname;
