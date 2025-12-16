WITH RECURSIVE TIME_MAP AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 FROM TIME_MAP WHERE hour < 23
)

SELECT 
    t.hour,                -- [중요] 기준 테이블(t)의 시간을 선택
    COUNT(a.animal_id)     -- [중요] ID가 없으면 0으로 세야 하므로 COUNT(*) 대신 컬럼 명시
FROM TIME_MAP t            -- [핵심] 시간 테이블이 '왼쪽(주인)'이어야 함
LEFT JOIN ANIMAL_OUTS a 
    ON t.hour = HOUR(a.datetime)
GROUP BY t.hour            -- [중요] 기준 테이블(t) 기준으로 그룹핑
ORDER BY t.hour;