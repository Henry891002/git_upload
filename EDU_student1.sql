CREATE TABLE SQL_OFFICE (
  村里別代碼 VARCHAR2 (4),
  村里別    NVARCHAR2(3),
  村里辦公室 NVARCHAR2 (30),
  村里辦公室電話 VARCHAR2 (30)
  );

commit;

CREATE TABLE SQL_OFFICE＿DATA (
  設施地址代號 CHAR(3),
  設施地址    NVARCHAR2(50),
  容人數量    VARCHAR2(10),
  地下樓層    CHAR(1),
  村里別代碼  VARCHAR2 (4),
  單位類別代碼  CHAR(3),
  );
commit;

CREATE TABLE SQL_OFFICE_APARTMENT (
 單位類別代碼 CHAR(3),
 類別        NVARCHAR2(4)
 );
commit;

CREATE TABLE SQL_POLICE(
 轄管分局代碼 CHAR(4),
 轄管分局    NVARCHAR2(4),
 分局地址    NVARCHAR2(20),
 分局電話    VARCHAR2(20)
 );

commit;



 
alter table SQL_OFFICE＿DATA add 轄管分局代碼 CHAR(4);
alter table SQL_OFFICE＿DATA modify 設施地址代號 CHAR(4);





 
  

