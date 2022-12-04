DROP database IF EXISTS ammo_db;

CREATE database ammo_db;

USE ammo_db;

CREATE TABLE ammo
(
    id           INT PRIMARY KEY auto_increment,
    type         varchar(20) not null,
    name         varchar(20) not null,
    cost         double      not null,
    weight       double      not null,
    durability   DECIMAL      not null,
    vision_level varchar(20),
    protection   double,
    damage       double

);

truncate table ammo;

SELECT *
FROM ammo;
