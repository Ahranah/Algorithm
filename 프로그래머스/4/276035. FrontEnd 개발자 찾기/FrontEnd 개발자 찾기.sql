-- 코드를 작성해주세요
select distinct a.id, a.email, a.first_name, a.last_name
from developers as a
inner join skillcodes as b on (a.skill_code & b.code != 0)
where b.category = 'Front End'
order by a.id;