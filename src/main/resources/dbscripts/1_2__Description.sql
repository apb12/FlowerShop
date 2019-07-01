create table "USERS"(
    "login" varchar(30) primary key,
    "password" varchar(30) not null,
    "username" varchar(50) not null,
    "email" varchar(50)not null,
    "balance" decimal ,
    "discount" int
);

insert into USERS values('admin', 'admin123', 'admin', 'admin@admin.com',10000,20);