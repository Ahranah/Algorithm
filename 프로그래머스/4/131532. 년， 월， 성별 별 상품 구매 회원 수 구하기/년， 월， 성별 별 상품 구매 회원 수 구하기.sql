-- 코드를 입력하세요
SELECT to_char(o.sales_date, 'YYYY') as YEAR, 
    to_number(to_char(o.sales_date, 'MM')) as MONTH,
    u.gender as GENDER,
    count(distinct u.user_id) as USERS
    -- online_sales에서 가져오려면 distinct
from user_info u 
join online_sale o on u.user_id = o.user_id
where u.gender is not null
group by to_char(o.sales_date, 'YYYY') ,to_char(o.sales_date, 'MM'), u.gender
order by year, month, gender
              