create table FLOWER(

    id number primary key,
    name varchar(30) not null,
    price decimal not null,
);

insert into FLOWER values(1,'Роза красная',35);
insert into FLOWER values(2,'Роза белая',25);
insert into FLOWER values(3,'Розая желтая',40);
insert into FLOWER values(4,'Хризантема белая',100);
insert into FLOWER values(5,'Хризантема красная',110);
insert into FLOWER values(6,'хризантема желтая',90);
insert into FLOWER values(7,'Орхидея белая',150);
insert into FLOWER values(8,'Орхидея красная',200);
insert into FLOWER values(9,'Орхидея желтая',130);
insert into FLOWER values(10,'Тюльпаны',10);
insert into FLOWER values(11,'Гвоздика',15);
insert into FLOWER values(12,'Жасмин',300);
insert into FLOWER values(13,'Лилии',180);
insert into FLOWER values(14,'Лотос',100);
insert into FLOWER values(15,'Жасмин королевский',300);
commit ;