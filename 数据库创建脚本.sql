drop table member purge;
create table member (
	mid			varchar2(50) ,
	name		varchar2(50) ,
	birthday	date ,
	salary		number ,
	note		clob ,
	del			number(1) ,
	constraint pk_mid primary key(mid)
) ;