-- 코드를 작성해주세요
with recursive generationTree as (
	select id, 1 as generation
	from ecoli_data
	where parent_id is null

    union all
    
    select e.id, g.generation +1
    from ecoli_data as e
    join generationTree as g on e.parent_id = g.id
)

select count(g.id) as count, g.generation
from generationTree as g
left join ecoli_data as e on e.parent_id = g.id
where e.id is null
group by g.generation
order by g.generation

