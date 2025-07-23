-- 코드를 입력하세요
-- DOCTOR 테이블에서 진료과가 흉부외과(CS)이거나 일반외과(GS)인
-- 의사의 이름, 의사ID, 진료과, 고용일자를 조회
-- 고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬
SELECT
DR_NAME, DR_ID, MCDP_CD, date_format(HIRE_YMD,'%Y-%m-%d') as HIRE_YMD
from DOCTOR
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by HIRE_YMD desc, DR_NAME;