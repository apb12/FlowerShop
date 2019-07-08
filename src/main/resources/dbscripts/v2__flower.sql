CREATE SEQUENCE FLOWER_SEQ;
CREATE TABLE FLOWER(

    ID NUMBER PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    PRICE DECIMAL NOT NULL
);

insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Роза красная',35);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Роза белая',25);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Розая желтая',40);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Хризантема белая',100);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Хризантема красная',110);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'хризантема желтая',90);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Орхидея белая',150);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Орхидея красная',200);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Орхидея желтая',130);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Тюльпаны',10);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Гвоздика',15);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Жасмин',300);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Лилии',180);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Лотос',100);
insert into FLOWER values(FLOWER_SEQ.NEXTVAL,'Жасмин королевский',300);
commit ;