-- 코드를 작성해주세요

select count(*) as FISH_COUNT, 
Max(length) as MAX_LENGTH, fish_type
from fish_info
group by fish_type
having avg(ifnull(length, 10)) >= 33
order by fish_type;