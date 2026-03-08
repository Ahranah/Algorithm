-- 코드를 입력하세요
SELECT member_id, member_name, gender as GENDER,
to_char(date_of_birth, 'YYYY-MM-DD') as DATE_OF_BIRTH
from member_profile
where gender = 'W' and to_number(to_char(date_of_birth, 'MM')) = 03
and tlno is not null 
order by member_id