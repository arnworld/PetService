DROP TABLE IF EXISTS TBL_EMPLOYEES;
  
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);



DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  version varchar(512) NOT NULL,
  name varchar(512) NOT NULL,
  price INT DEFAULT NULL,
  product_id varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);



DROP TABLE IF EXISTS pet;

CREATE TABLE pet (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name varchar(512) NOT NULL,
  type varchar(512) NOT NULL,
  price INT DEFAULT NULL,
  PRIMARY KEY (id)
);
