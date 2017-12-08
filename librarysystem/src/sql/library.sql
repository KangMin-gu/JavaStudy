create table manager (jumin number primary key, mname varchar(20)  not null, mphone varchar(20)  not null, maddr varchar(100)  not null);

create table general (gjumin number primary key, gname varchar(20) not null, gphone varchar(20)  not null, gaddr varchar(100)  not null);

create table booklist (
isbn number primary key, 
genre varchar(20) not null, 
bkname varchar(30) not null, 
writer varchar(30) not null, 
publisher varchar(30) not null, 
price number not null, 
rentalfee number not null);

insert into booklist (isbn, genre, bkname, writer, publisher, price, rentalfee) values (1, '소설', '정글만리', '조정래', '해냄', 27000, 2700);
insert into booklist (isbn, genre, bkname, writer, publisher, price, rentalfee) values (2, '소설', '82년생김지영', '조남주', '민음사', 13000, 1300);
insert into booklist (isbn, genre, bkname, writer, publisher, price, rentalfee) values (3, '에세이', '섬', '정현종', '문학판', 12600, 1260);
insert into booklist (isbn, genre, bkname, writer, publisher, price, rentalfee) values (4, '자기개발', '자존감수업', '윤홍균', '심플라이프', 11000, 1100);


