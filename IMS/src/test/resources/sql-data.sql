INSERT INTO Customers (`first_name`, `last_name`) VALUES ('jordan', 'harrison');
INSERT INTO Items (`item_name`, `item_value`) VALUES ('Car', 10.0);
INSERT INTO Orders (`fk_customer_id`) VALUES (1);
INSERT INTO Requests(`fk_order_id`,`fk_item_id`,`quantity`) VALUES (1,1,2);
