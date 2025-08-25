-- 코드를 작성해주세요
-- 연도별 가장큰
select
	YEAR(DIFFERENTIATION_DATE) as YEAR,
     (
     	(select MAX(SIZE_OF_COLONY)
         from ECOLI_DATA
         where YEAR(DIFFERENTIATION_DATE) = YEAR(e.DIFFERENTIATION_DATE))
     	- e.SIZE_OF_COLONY
     ) as YEAR_DEV
     ,
    ID
from ECOLI_DATA e
ORDER BY
    YEAR ASC,
    YEAR_DEV ASC;
