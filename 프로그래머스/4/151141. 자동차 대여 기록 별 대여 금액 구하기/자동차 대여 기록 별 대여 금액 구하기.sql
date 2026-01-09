WITH history AS (
    SELECT 
        h.history_id,
        h.car_id,
        c.car_type,  -- JOIN을 위해 추가
        c.daily_fee,
        (h.end_date - h.start_date + 1) AS duration,
        CASE
            WHEN (h.end_date - h.start_date + 1) >= 90 THEN '90일 이상'
            WHEN (h.end_date - h.start_date + 1) >= 30 THEN '30일 이상'
            WHEN (h.end_date - h.start_date + 1) >= 7 THEN '7일 이상'
            ELSE NULL
        END AS duration_type
    FROM car_rental_company_rental_history h
    JOIN car_rental_company_car c ON c.car_id = h.car_id
    WHERE c.car_type = '트럭'
)

SELECT 
    h.history_id, 
    -- 최종 대여 금액 계산
    ROUND(h.daily_fee * h.duration * (1 - NVL(d.discount_rate, 0) * 0.01)) AS fee
FROM history h 
LEFT JOIN car_rental_company_discount_plan d 
    ON h.car_type = d.car_type 
    AND h.duration_type = d.duration_type -- 기간 타입 매칭 필수
ORDER BY fee DESC, h.history_id DESC;