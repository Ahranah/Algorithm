-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME
from animal_outs as a
where not exists(
    select 1
    from animal_ins as i
    where i.animal_id = a.animal_id);