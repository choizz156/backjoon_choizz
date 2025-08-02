-- 코드를 입력하세요
SELECT
hour(datetime) as HOUR, count(ANIMAL_ID) as COUNT
from ANIMAL_OUTS
group by hour(datetime) 
having HOUR between 9 and 20
order by hour(datetime);