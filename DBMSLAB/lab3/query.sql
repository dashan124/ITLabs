use hospital;
-- query 1 solution

select * from NURSE where registered=false;

-- 2 query

select d.name as DEPARTMENT,p.name as PHYSICIAN from  DEPARTMENT d, PHYSICIAN p where d.head=p.employeeid;
