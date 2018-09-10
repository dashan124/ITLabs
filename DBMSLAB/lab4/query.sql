select t.name as "name of patient",
    p.name as "name of physicain"
    from PATIENT t 
    join PHYSICIAN p on p.employeeid=t.pcp
    where t.pcp not in (select head from DEPARTMENT);

-- select t.name as "Patient name",
--     from PATIENT t 
--     join APPOINTMENT a on a.patient=t.ssn
--     where COUNT(a.patient)>=2;

-- 3 rd 

select t.name as "Patient Name",
    from PATIENT t
    join UNDERGOES u on u.procedure=PROCEDUERE.code
    join UNDERGOES u on u.patient=t.ssn 
    where PROCEDUERE.cost>5000;