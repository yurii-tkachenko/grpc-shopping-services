drop table if exists orders;
drop table if exists users;

CREATE TABLE users (
  id numeric(11) NOT NULL AUTO_INCREMENT,
  username varchar2(50) DEFAULT NULL,
  password varchar2(50) DEFAULT NULL,
  name varchar2(50) DEFAULT NULL,
  gender varchar2(50) DEFAULT NULL,
  age numeric(11) DEFAULT NULL,
  PRIMARY KEY (id)
);


INSERT INTO users
VALUES
(1,'admin','admin','John Doe','MALE', 28),
(2,'christian','christian','Christian Bale','MALE', 35),
(3,'hugh','hugh','Hugh Jackman','MALE', 45),
(4,'ross','ross','Ross Geller','MALE', 35),
(5,'chandler','chandler','Chandler Bing','MALE',35),
(6,'monica','monica','Monica Geller','FEMALE',34),
(7,'rachel','rachel','Rachel Greene','FEMALE',40),
(8,'pheobe','pheobe','Pheobe Buffay','FEMALE',40);


CREATE TABLE orders (
  order_id numeric(11) NOT NULL AUTO_INCREMENT,
  user_id numeric(11) DEFAULT NULL,
  no_of_items numeric(11) DEFAULT NULL,
  total_amount double DEFAULT NULL,
  order_date date DEFAULT NULL,
  PRIMARY KEY (order_id),
  foreign key (user_id) references users(id)
 );


INSERT INTO orders VALUES (1,5,3,635,'2020-01-10'),(2,8,1,1045,'2020-10-13');
