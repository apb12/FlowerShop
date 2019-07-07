create sequence FLOWER_SEQ;
create table FLOWER(

    id number primary key,
    name varchar(30) not null,
    price decimal not null,
    foreign key (id) references flowerstock(id)
);

insert into FLOWER values(FLOWER_SEQ.nextval,'Роза красная',35);
insert into FLOWER values(FLOWER_SEQ.nextval,'Роза белая',25);
insert into FLOWER values(FLOWER_SEQ.nextval,'Розая желтая',40);
insert into FLOWER values(FLOWER_SEQ.nextval,'Хризантема белая',100);
insert into FLOWER values(FLOWER_SEQ.nextval,'Хризантема красная',110);
insert into FLOWER values(FLOWER_SEQ.nextval,'хризантема желтая',90);
insert into FLOWER values(FLOWER_SEQ.nextval,'Орхидея белая',150);
insert into FLOWER values(FLOWER_SEQ.nextval,'Орхидея красная',200);
insert into FLOWER values(FLOWER_SEQ.nextval,'Орхидея желтая',130);
insert into FLOWER values(FLOWER_SEQ.nextval,'Тюльпаны',10);
insert into FLOWER values(FLOWER_SEQ.nextval,'Гвоздика',15);
insert into FLOWER values(FLOWER_SEQ.nextval,'Жасмин',300);
insert into FLOWER values(FLOWER_SEQ.nextval,'Лилии',180);
insert into FLOWER values(FLOWER_SEQ.nextval,'Лотос',100);
insert into FLOWER values(FLOWER_SEQ.nextval,'Жасмин королевский',300);
commit ;