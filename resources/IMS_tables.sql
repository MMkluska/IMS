CREATE DATABASE IF NOT EXISTS ims;
USE ims;

CREATE TABLE IF NOT EXISTS Customers (
  customer_id INT NOT NULL AUTO_INCREMENT,
  first_name varchar(25),
  last_name varchar(25),
  PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS Orders (
  order_id INT NOT NULL AUTO_INCREMENT,
  fk_customer_id INT,
  PRIMARY KEY (order_id),
  FOREIGN KEY (fk_customer_id) REFERENCES Customers(customer_id)
);


CREATE TABLE IF NOT EXISTS Items (
  item_id INT NOT NULL AUTO_INCREMENT,
  item_name varchar(50),
  item_value decimal(6,2),
  PRIMARY KEY (item_id)
  );
  
  CREATE TABLE IF NOT EXISTS Requests (
  request_id INT NOT NULL AUTO_INCREMENT,
  fk_order_id INT NOT NULL,
  fk_item_id INT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (request_id),
  FOREIGN KEY (fk_order_id) REFERENCES Orders(order_id),
  FOREIGN KEY (fk_item_id) REFERENCES Items(item_id)
);
