CREATE SCHEMA `pumbank` ;

USE mysql;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'eu123';
GRANT ALL PRIVILEGES ON pumbank.* TO 'user'@'localhost';
FLUSH PRIVILEGES;

USE pumbank;