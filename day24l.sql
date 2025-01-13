drop database if exists day24l;

create database if not exists day24l;

use day24l;

create table BankAccount(
    id int not null auto_increment,
    fullname varchar(150) not null,
    isActive boolean,
    balance float default 100.0,
    
    constraint pk_bankaccount_id primary key (id)
);

insert into BankAccount
        (fullName, isActive, balance)
    values
        ('Test Account', true, 300.0);

select * from BankAccount;

select * from BankAccount where id = 1;

-- DeleteMapping
update BankAccount set isActive  = false where id = 1;

-- PutMapping
update BankAccount set balance = 500 where id = 1;


