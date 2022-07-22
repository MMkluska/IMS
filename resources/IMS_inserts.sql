USE ims;

INSERT INTO Customers (`first_name`, `last_name`) VALUES ('Jordan', 'Harrison');
INSERT INTO Customers (`first_name`, `last_name`) VALUES ('Phillip', 'Cook');
INSERT INTO Customers (`first_name`, `last_name`) VALUES ('Brad', 'Morley');
INSERT INTO Customers (`first_name`, `last_name`) VALUES ('Izabela', 'Randall');
INSERT INTO Customers (`first_name`, `last_name`) VALUES ('Natalie', 'Fleming');

INSERT INTO Items (`item_name`, `item_value`) VALUES ('Mouse', 14.5);
INSERT INTO Items (`item_name`, `item_value`) VALUES ('Keyboard', 12.3);
INSERT INTO Items (`item_name`, `item_value`) VALUES ('Screen', 112.0);
INSERT INTO Items (`item_name`, `item_value`) VALUES ('Speakers', 24.9);
INSERT INTO Items (`item_name`, `item_value`) VALUES ('Desk', 53.3);

INSERT INTO Orders (`fk_customer_id`) VALUES (4);
INSERT INTO Orders (`fk_customer_id`) VALUES (2);
INSERT INTO Orders (`fk_customer_id`) VALUES (4);
INSERT INTO Orders (`fk_customer_id`) VALUES (1);
INSERT INTO Orders (`fk_customer_id`) VALUES (5);

INSERT INTO Requests(`fk_order_id`,`fk_item_id`,`quantity`) VALUES (3,5,2);
INSERT INTO Requests(`fk_order_id`,`fk_item_id`,`quantity`) VALUES (2,4,3);
INSERT INTO Requests(`fk_order_id`,`fk_item_id`,`quantity`) VALUES (3,3,1);
INSERT INTO Requests(`fk_order_id`,`fk_item_id`,`quantity`) VALUES (4,2,3);
INSERT INTO Requests(`fk_order_id`,`fk_item_id`,`quantity`) VALUES (1,4,2);
