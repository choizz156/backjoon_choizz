-- 코드를 입력하세요
SELECT
book_id, date_format(published_date,'%Y-%m-%d') as PUBLISHED_DATE
from book
where date_format(published_date, '%Y') = '2021' and category = '인문'
order by PUBLISHED_DATE;