-- user_info: 21년에 가입한 사람 총 수
-- join하면 가입한 총 인원은 사라진다.
-- 21년에 가입한 사람 중에 물건 산 사람 (online_sale whose user_id가 있고, sales_date가 2021인 사람)
-- group by year, month

SELECT 
    to_char(o.sales_date, 'YYYY') as year,
    to_number(to_char(o.sales_date, 'MM')) as month,
    count(distinct o.user_id) as purchased_users,
    round(count(distinct o.user_id) / 
          (select count(*) from user_info where to_char(joined, 'YYYY') = '2021'), 1) as purchased_ratio
from user_info a
join online_sale o on a.user_id = o.user_id 
where to_char(a.joined, 'YYYY') = '2021'
group by to_char(o.sales_date, 'YYYY'), to_char(o.sales_date, 'MM')
order by year, month