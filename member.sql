--테이블 생성
create table Member(
    name    varchar2(20),
    id      varchar2(20),
    pw      varchar2(20),
    age     number,
    addr    varchar(50),
    tel     varchar(20)
);

--전체레코드 검색
select *
from   member;


