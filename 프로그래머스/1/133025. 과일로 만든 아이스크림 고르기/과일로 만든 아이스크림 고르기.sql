-- 코드를 입력하세요
-- 상반기
-- 아이스크림 총주문량이 3,000보다 높으면서
-- 아이스크림의 주 성분이 과일
-- 아이스크림의 맛
-- 총주문량이 큰 순서대로 조회

select h.FLAVOR
from FIRST_HALF h
join ICECREAM_INFO i on h.FLAVOR = i.FLAVOR
where i.INGREDIENT_TYPE = 'fruit_based' and h.TOTAL_ORDER > 3000
order by h.TOTAL_ORDER desc;
