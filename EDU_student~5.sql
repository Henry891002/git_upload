--4-1
select "�e�H�ƶq",SQL_POLICE."�Һޤ���",SQL_POLICE."�����q��"
from SQL_OFFICE��DATA
left join SQL_POLICE on SQL_OFFICE��DATA."�Һޤ����N�X"=SQL_POLICE."�Һޤ����N�X"
where "�e�H�ƶq" >1000;

--4-2
select count (SQL_OFFICE��DATA."�Һޤ����N�X") over(partition by SQL_OFFICE��DATA."�Һޤ����N�X") as �]�I�ƶq,
              SQL_POLICE."�����a�}",
              SQL_POLICE."�����q��"
from SQL_OFFICE��DATA
left join SQL_POLICE on SQL_OFFICE��DATA."�Һޤ����N�X"=SQL_POLICE."�Һޤ����N�X"
where "�e�H�ƶq" >1000;
--group by SQL_POLICE."�����a�}",SQL_POLICE."�����q��";

--4-3
select count (SQL_OFFICE��DATA."�Һޤ����N�X")as �]�I�ƶq,
              SQL_POLICE."�Һޤ����N�X",
              SQL_POLICE."�����q��",
              SQL_OFFICE��DATA."�]�I�a�}",
              SQL_POLICE."�����a�}"
from SQL_OFFICE��DATA
left join SQL_POLICE on SQL_OFFICE��DATA."�Һޤ����N�X"=SQL_POLICE."�Һޤ����N�X"
where "�e�H�ƶq" >1000
group by  SQL_POLICE."�Һޤ����N�X",SQL_POLICE."�����a�}", SQL_OFFICE��DATA."�]�I�a�}",SQL_POLICE."�����q��";

--4-4
select  SQL_OFFICE��DATA."�]�I�a�}",
        SQL_POLICE."�Һޤ���",
        SQL_OFFICE."�����O",
        SQL_OFFICE��DATA."�e�H�ƶq",
        SQL_POLICE."�����q��"
 from  SQL_OFFICE
 left join SQL_OFFICE��DATA on SQL_OFFICE��DATA.�����O�N�X = SQL_OFFICE.�����O�N�X
 left join SQL_POLICE on SQL_OFFICE��DATA.�Һޤ����N�X = SQL_POLICE.�Һޤ����N�X
 where SQL_OFFICE��DATA."�]�I�a�}" like '%��%';

--4-5
select  
        SQL_OFFICE.�����O,
        SQL_OFFICE.�����줽��,
        SQL_OFFICE��DATA.�]�I�a�},
        SQL_OFFICE��DATA.�e�H�ƶq
from    SQL_OFFICE��DATA
left join SQL_OFFICE on SQL_OFFICE��DATA.�����O�N�X=SQL_OFFICE.�����O�N�X
left join SQL_OFFICE_APARTMENT on SQL_OFFICE��DATA.������O�N�X=SQL_OFFICE_APARTMENT.������O�N�X
--where SQL_OFFICE_APARTMENT.���O='���J' or SQL_OFFICE_APARTMENT.���O='�j��';
where SQL_OFFICE_APARTMENT.���O in('���J','�j��');        
--5-1

update SQL_OFFICE��DATA
set"�e�H�ƶq"=5000
where SQL_OFFICE��DATA.�]�I�a�}='�]�߿��˫n��M����79��';

--5-2
delete from SQL_OFFICE��DATA 
where "�e�H�ƶq" <1000;

commit;
 