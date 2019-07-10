CREATE SEQUENCE USERS_SEQ;
create table USERS(
    ID NUMBER PRIMARY KEY,
    login varchar(30) UNIQUE,
    password varchar(30) not null,
    username varchar(50) not null,
    email varchar(50)not null,
    balance decimal ,
    discount int,
);

insert into USERS values(USERS_SEQ.NEXTVAL,'stas', '111', 'stas', 'stas@admin.com',2000,10);
insert into USERS values(USERS_SEQ.NEXTVAL,'admin', 'admin123', 'admin', 'admin@admin.com',10000,20);
commit ;