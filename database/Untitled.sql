drop database if exists bison_project;
create database bison_project;
use bison_project;

create table category (
id int primary key auto_increment,
name varchar(255)
);

create table food (
id int primary key auto_increment,
delete_status tinyint(1),
name varchar(255),
description varchar(255),
price double,
discount double,
start_time varchar(255),
category_id int,
foreign key (category_id) references category (id) 
);

create table image_food(
id int primary key auto_increment,
url varchar (255),
food_id int,
foreign key (food_id) references food(id) 
);

create table account (
id int primary key auto_increment,
delete_status tinyint(1),
password varchar (255),
username varchar(255)
);

create table role (
id int primary key auto_increment,
name varchar(255)
);

create table account_role (
id int primary key auto_increment,
account_id int,
role_id int,
foreign key (account_id) references account(id),
foreign key (role_id) references role(id)
);

create table date_of_birth(
id int primary key auto_increment,
day varchar (255),
month varchar (255),
year varchar (255)
);

create table user(
id int primary key auto_increment,
avatar varchar (255),
email varchar (255),
id_card varchar (255),
phone varchar (255),
account_id int,
date_id int,
foreign key (account_id) references account(id),
foreign key (date_id) references date_of_birth(id)
);

create table payment(
id int primary key auto_increment,
delete_status tinyint(1),
payment_status bit,
shipping_description varchar(255),
user_id int,
food_id int,
foreign key (user_id) references user(id),
foreign key (food_id) references food(id)
);

create table promotion(
id int primary key auto_increment,
title varchar(255),
start_time varchar(255),
end_time varchar(255),
description varchar(255)
);



