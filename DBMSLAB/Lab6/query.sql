use social;
-- 3 query
create view X as select name, grade from Highschooler
where ID not in (select ID1 from Highschooler H1, Friend, Highschooler H2
where H1.ID=Friend.ID1 and Friend.ID2=H2.ID and H1.grade<>H2.grade) order by grade, name;
select * from X;

-- 5th query 

create function Get_salarylvl(salary DECIMAL(18,4)) returns varchar(20)
deterministic 
begin 
    declare lvl varchar(20);
    if salary<30000 then 
        set lvl='low';
    else if (salary>=30000 and salary<=50000) then 
        set lvl='average';
    else if (salary>50000) then 
        set lvl='high';
return (lvl);
end; 