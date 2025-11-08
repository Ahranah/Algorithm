-- 코드를 작성해주세요
select a.id
from ecoli_data as a
inner join ecoli_data as b 
    on a.parent_id = b.id
        inner join ecoli_data as c
            on b.parent_id = c.id and c.parent_id is null
order by a.id;