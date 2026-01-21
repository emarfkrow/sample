DROP DATABASE IF EXISTS emarf; 

CREATE DATABASE emarf CHARACTER SET utf8mb4;

DROP USER IF EXISTS emarf@localhost; 

CREATE USER emarf@localhost IDENTIFIED BY 'emarf';

GRANT ALL PRIVILEGES ON emarf.* TO emarf@localhost WITH GRANT OPTION;

SELECT * FROM mysql.USER;
