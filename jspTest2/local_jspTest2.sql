--���̺� ����

create table board (
no number not null primary key,
writer varchar2(500) not null,
subject varchar2(500) not null,
content clob not null,
regi_date date default sysdate
);

drop table board;
--commit
commit;

desc board;


--������ ����
create SEQUENCE seq_board start with 1 increment by 1 minvalue 1;


--�н����� Į�� �߰�

 alter table board add passwd varchar2(50) not null;
 
 commit;