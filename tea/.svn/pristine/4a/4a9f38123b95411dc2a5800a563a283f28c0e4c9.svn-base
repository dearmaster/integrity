drop database if exists spark;
create database spark CHARACTER SET utf8 COLLATE utf8_general_ci;

drop database if exists spark_security;
create database spark_security CHARACTER SET utf8 COLLATE utf8_general_ci;

drop database if exists moon;
create database moon CHARACTER SET utf8 COLLATE utf8_general_ci;

drop database if exists moon_security;
create database moon_security CHARACTER SET utf8 COLLATE utf8_general_ci;

drop database if exists rain;
create database rain CHARACTER SET utf8 COLLATE utf8_general_ci;

drop database if exists rain_security;
create database rain_security CHARACTER SET utf8 COLLATE utf8_general_ci;

show databases;

create user fish@'localhost' identified by 'peace4';

grant all privileges on spark.* to fish;
grant all privileges on spark_security.* to fish;
grant all privileges on moon.* to fish;
grant all privileges on moon_security.* to fish;
grant all privileges on rain.* to fish;
grant all privileges on rain_security.* to fish;

SHOW VARIABLES LIKE 'character%'; --check the db encoding
SHOW CREATE TABLE moon.user_tbl;
SHOW CREATE TABLE moon.user_credential_tbl;