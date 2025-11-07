-- 코드를 작성해주세요
select distinct a.ID, a.EMAIL, a.FIRST_NAME, a.LAST_NAME
from developers as a
inner join skillcodes as b on (a.skill_code & b.code) != 0
where b.category ='Front End'
order by a.ID;