CREATE TABLE SQL_OFFICE (
  �����O�N�X VARCHAR2 (4),
  �����O    NVARCHAR2(3),
  �����줽�� NVARCHAR2 (30),
  �����줽�ǹq�� VARCHAR2 (30)
  );

commit;

CREATE TABLE SQL_OFFICE��DATA (
  �]�I�a�}�N�� CHAR(3),
  �]�I�a�}    NVARCHAR2(50),
  �e�H�ƶq    VARCHAR2(10),
  �a�U�Ӽh    CHAR(1),
  �����O�N�X  VARCHAR2 (4),
  ������O�N�X  CHAR(3),
  );
commit;

CREATE TABLE SQL_OFFICE_APARTMENT (
 ������O�N�X CHAR(3),
 ���O        NVARCHAR2(4)
 );
commit;

CREATE TABLE SQL_POLICE(
 �Һޤ����N�X CHAR(4),
 �Һޤ���    NVARCHAR2(4),
 �����a�}    NVARCHAR2(20),
 �����q��    VARCHAR2(20)
 );

commit;



 
alter table SQL_OFFICE��DATA add �Һޤ����N�X CHAR(4);
alter table SQL_OFFICE��DATA modify �]�I�a�}�N�� CHAR(4);





 
  

