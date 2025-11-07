-- 코드를 입력하세요
SELECT a.flavor
from first_half as a
left join (
    select flavor, sum(total_order) as july_total
    from july
    group by flavor    
) as b on a.flavor = b.flavor
order by a.total_order + ifnull(b.july_total, 0) desc
limit 3