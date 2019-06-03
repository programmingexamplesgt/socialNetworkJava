use mysql;

create database social_network_db;

use social_network_db;

create table user(
  id int primary key auto_increment not null,
  email varchar(64),
  password varchar(128) not null,
  firstname varchar(64) not null,
  lastname varchar(64) not null,
  last_login datetime,
  date_joined datetime,
  is_active tinyint default 1
);

create table friendship(
  id int primary key auto_increment not null,
  user_id_1 int not null,
  user_id_2 int not null,
  friendship_date date,
  is_active tinyint default 0,
  foreign key (user_id_1) references user(id), 
  foreign key (user_id_2) references user(id),
  unique(user_id_1, user_id_2)
);

create table post(
  id bigint primary key auto_increment not null,
  user_id int not null,
  message text not null,
  published datetime not null,
  edited datetime,
  is_visible tinyint(1) default 1,
  foreign key (user_id) references user(id)
);

create table rection(
  id int primary key auto_increment not null,
  name varchar(32) not null
);

create table post_reaction(
  id bigint primary key auto_increment not null,
  post_id bigint not null,
  reaction_id int not null,
  user_id int not null,
  foreign key (post_id) references post(id),
  foreign key (reaction_id) references rection(id),
  foreign key (user_id) references user(id)
);