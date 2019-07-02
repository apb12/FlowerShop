create table FLOWER(

    id int primary key,
    name varchar(30) not null,
    price decimal not null,
    total int
);

insert into FLOWER values(1, 'Роза красная',35,150);
insert into FLOWER values(2, 'Роза белая',25,100);
insert into FLOWER values(3, 'Розая желтая',40,100);
insert into FLOWER values(4, 'Хризантема белая',100,80);
insert into FLOWER values(5, 'Хризантема красная',110,30);
insert into FLOWER values(6, 'хризантема желтая',90,40);
insert into FLOWER values(7, 'Орхидея белая',150,100);
insert into FLOWER values(8, 'Орхидея красная',200,200);
insert into FLOWER values(9, 'Орхидея желтая',130,50);
insert into FLOWER values(10, 'Тюльпаны',10,200);
insert into FLOWER values(12, 'Гвоздика',15,1000);
insert into FLOWER values(13, 'Жасмин',300,25);
insert into FLOWER values(14, 'Лилии',180,40);
insert into FLOWER values(15, 'Лотос',100,15);
insert into FLOWER values(16, 'Жасмин королевский',300,25);

commit ;