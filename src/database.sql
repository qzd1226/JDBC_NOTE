create database JDBC_Learn;
use JDBC_Learn;
create table customers(
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (20),
    email VARCHAR (50),
    birth DATE
);