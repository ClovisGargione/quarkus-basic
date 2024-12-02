CREATE DATABASE `quarkus`;

CREATE TABLE USERS(
 	id numeric AUTO_INCREMENT primary key not null,
 	name varchar(100) not null,
 	age int not null
);