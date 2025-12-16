-- 코드를 입력하세요
SELECT t.hour, count(a.animal_id) as count
from (
    select level-1 as hour -- level은 1부터 시작
    from dual
    connect by level <= 24
) t
left join animal_outs a 
on t.hour = to_number(to_char(a.datetime, 'HH24'))
group by t.hour
order by t.hour

