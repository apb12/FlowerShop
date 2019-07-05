create table FLOWER(

    id number primary key,
    name varchar(30) not null,
    price decimal not null,
);

insert into FLOWER values(100,'Роза красная',35);
insert into FLOWER values(101,'Роза белая',25);
insert into FLOWER values(102,'Розая желтая',40);
insert into FLOWER values(103,'Хризантема белая',100);
insert into FLOWER values(104,'Хризантема красная',110);
insert into FLOWER values(105,'хризантема желтая',90);
insert into FLOWER values(106,'Орхидея белая',150);
insert into FLOWER values(107,'Орхидея красная',200);
insert into FLOWER values(108,'Орхидея желтая',130);
insert into FLOWER values(109,'Тюльпаны',10);
insert into FLOWER values(110,'Гвоздика',15);
insert into FLOWER values(111,'Жасмин',300);
insert into FLOWER values(112,'Лилии',180);
insert into FLOWER values(113,'Лотос',100);
insert into FLOWER values(114,'Жасмин королевский',300);
commit ;