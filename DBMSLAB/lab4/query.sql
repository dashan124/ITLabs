-- 1 query 
select t.name as "name of patient",
    p.name as "name of physicain"
    from PATIENT t 
    join PHYSICIAN p on p.employeeid=t.pcp
    where t.pcp not in (select head from DEPARTMENT);

 -- 2 query 
select pt.name, ph.name 
from PATIENT pt, PHYSICIAN ph 
WHERE pt.pcp = ph.employeeid and 2 <= (select count(a.appointmentid) from APPOINTMENT a, NURSE n 
where a.prepnurse = n.employeeid and n.registered = 1 and a.patient=pt.ssn);



-- select t.name as "Patient Name",
--     from PATIENT t
--     join UNDERGOES u on u.procedure=PROCEDUERE.code
--     join UNDERGOES u on u.patient=t.ssn 
--     where PROCEDUERE.cost>5000;


-- 3 query 
select p.name, ph.name from UNDERGOES u 
join PATIENT p on p.ssn=u.patient 
join PHYSICIAN ph on p.pcp=ph.employeeid 
join PROCEDURES mp on u.procedures=mp.code where mp.cost > 5000;


-- 4 query 
 select p.name as physician,
  p.position as position, 
  pr.name_pro as proc, u.date, 
  pt.name as patient, t.certificationexp  
   from PHYSICIAN p, UNDERGOES u, PATIENT pt, PROCEDURES pr, TRAINED_IN t
  where u.patient = pt.ssn     and u.procedures = pr.code     and u.physician = p.employeeid  
  and pr.code = t.treatment     and p.employeeid = t.physician     and u.date > t.certificationexp;


 -- 5 th query 
 
select p.name from PHYSICIAN p
 where employeeid in (select  physician from UNDERGOES u 
 where not exists (select * from TRAINED_IN where treatment = procedures and physician=u.physician));



 