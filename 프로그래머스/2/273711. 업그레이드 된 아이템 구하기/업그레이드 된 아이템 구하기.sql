-- 코드를 작성해주세요
# 'ITEM_C'의 PARENT 아이템은 'ITEM_B'
# 'ITEM_B'의 PARENT 아이템은 'ITEM_A'
# ROOT 아이템은 'ITEM_A'가 됩니다.

# select
# t.ITEM_ID, i.ITEM_NAME, i.RARITY
# from ITEM_INFO i
# join ITEM_TREE t on i.ITEM_ID = t.PARENT_ITEM_ID
# where i.RARITY = 'RARE'
# order by t.ITEM_ID desc;


select
i.ITEM_ID, i.ITEM_NAME, i.RARITY
from (select
t.ITEM_ID, i.RARITY
from ITEM_INFO i
join ITEM_TREE t on i.ITEM_ID = t.PARENT_ITEM_ID
where i.RARITY = 'RARE') as tmp
join ITEM_INFO i on i.ITEM_ID = tmp.ITEM_ID
order by i.ITEM_ID desc;







