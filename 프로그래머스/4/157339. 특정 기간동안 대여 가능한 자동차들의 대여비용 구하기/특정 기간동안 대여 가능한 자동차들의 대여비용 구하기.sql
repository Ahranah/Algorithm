SELECT *
FROM (
    SELECT 
        C.CAR_ID,
        C.CAR_TYPE,
        -- 30일 대여 금액 계산 (할인율 적용)
        ROUND(C.DAILY_FEE * 30 * (1 - P.DISCOUNT_RATE * 0.01)) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR C
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P 
        ON C.CAR_TYPE = P.CAR_TYPE 
        AND P.DURATION_TYPE = '30일 이상' -- 30일 대여이므로 '30일 이상' 할인 플랜 고정
    WHERE C.CAR_TYPE IN ('세단', 'SUV')
      -- 2022년 11월에 대여 기록이 있는 차들은 제외
      AND C.CAR_ID NOT IN (
          SELECT CAR_ID
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
          WHERE END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
            AND START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD')
      )
) 
WHERE FEE >= 500000 AND FEE < 2000000 -- 서브쿼리 바깥에서 FEE 조건 필터링
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;