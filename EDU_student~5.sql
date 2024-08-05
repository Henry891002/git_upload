--4-1
select "容人數量",SQL_POLICE."轄管分局",SQL_POLICE."分局電話"
from SQL_OFFICE＿DATA
left join SQL_POLICE on SQL_OFFICE＿DATA."轄管分局代碼"=SQL_POLICE."轄管分局代碼"
where "容人數量" >1000;

--4-2
select count (SQL_OFFICE＿DATA."轄管分局代碼") over(partition by SQL_OFFICE＿DATA."轄管分局代碼") as 設施數量,
              SQL_POLICE."分局地址",
              SQL_POLICE."分局電話"
from SQL_OFFICE＿DATA
left join SQL_POLICE on SQL_OFFICE＿DATA."轄管分局代碼"=SQL_POLICE."轄管分局代碼"
where "容人數量" >1000;
--group by SQL_POLICE."分局地址",SQL_POLICE."分局電話";

--4-3
select count (SQL_OFFICE＿DATA."轄管分局代碼")as 設施數量,
              SQL_POLICE."轄管分局代碼",
              SQL_POLICE."分局電話",
              SQL_OFFICE＿DATA."設施地址",
              SQL_POLICE."分局地址"
from SQL_OFFICE＿DATA
left join SQL_POLICE on SQL_OFFICE＿DATA."轄管分局代碼"=SQL_POLICE."轄管分局代碼"
where "容人數量" >1000
group by  SQL_POLICE."轄管分局代碼",SQL_POLICE."分局地址", SQL_OFFICE＿DATA."設施地址",SQL_POLICE."分局電話";

--4-4
select  SQL_OFFICE＿DATA."設施地址",
        SQL_POLICE."轄管分局",
        SQL_OFFICE."村里別",
        SQL_OFFICE＿DATA."容人數量",
        SQL_POLICE."分局電話"
 from  SQL_OFFICE
 left join SQL_OFFICE＿DATA on SQL_OFFICE＿DATA.村里別代碼 = SQL_OFFICE.村里別代碼
 left join SQL_POLICE on SQL_OFFICE＿DATA.轄管分局代碼 = SQL_POLICE.轄管分局代碼
 where SQL_OFFICE＿DATA."設施地址" like '%中%';

--4-5
select  
        SQL_OFFICE.村里別,
        SQL_OFFICE.村里辦公室,
        SQL_OFFICE＿DATA.設施地址,
        SQL_OFFICE＿DATA.容人數量
from    SQL_OFFICE＿DATA
left join SQL_OFFICE on SQL_OFFICE＿DATA.村里別代碼=SQL_OFFICE.村里別代碼
left join SQL_OFFICE_APARTMENT on SQL_OFFICE＿DATA.單位類別代碼=SQL_OFFICE_APARTMENT.單位類別代碼
--where SQL_OFFICE_APARTMENT.類別='公寓' or SQL_OFFICE_APARTMENT.類別='大樓';
where SQL_OFFICE_APARTMENT.類別 in('公寓','大樓');        
--5-1

update SQL_OFFICE＿DATA
set"容人數量"=5000
where SQL_OFFICE＿DATA.設施地址='苗栗縣竹南鎮和平街79號';

--5-2
delete from SQL_OFFICE＿DATA 
where "容人數量" <1000;

commit;
 