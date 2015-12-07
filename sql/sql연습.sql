


--insert
insert into guestbook
values(GUESTBOOK_SEQ.NEXTVAL,'kimm','1234','ㅎㅇ',SYSDATE);

--delete
delete from guestbook where no=1 and password='2345'; 


--select 
select no,name,password,message,to_char(reg_date, 'YYYY-MM-DD HH:MI:SS') from guestbook;

commit;