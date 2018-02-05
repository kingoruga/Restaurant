Insert into Service_areas values (40201);
Insert into Service_areas values (30201);
Insert into Service_areas values (25301);
Insert into Service_areas values (10001);

Insert Into Address (street, city, zip_code, state) values ('125 Main rd.', 'Houston',40201,'TX');

Insert Into Address (street, city, zip_code, state) values ('34 Grand Ave.','New York',30201, 'NY');

Insert Into Address (street, city, zip_code, state) values ('1001 Walkers Ct.', 'Atlanta',25301,'GA');

Insert Into Address (street, city, zip_code, state) values ('N 50th St.','Miami', 10001,'FL');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Jane', 'Broom', 'No', 'Bit2','JBroom@ymail.com',(Select Address_id from Address where state='TX') ,'Enabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Dan', 'Bay', 'No', '2Gj','dbay@ymail.com',(Select Address_id from Address where state='NY') ,'Enabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Joel', 'Moss', 'No', 'jmo34','Jmo@ymail.com',(Select Address_id from Address where state='GA') ,'Enabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Geel', 'Dak', 'No', 'seeme4','JBroom@ymail.com',(Select Address_id from Address where state='FL') ,'Disabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('asd', 'asd', 'Yes', 'asd','asd',(Select Address_id from Address where state='FL') ,'Enabled');



insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Aloo Gobi', 'Cauliflower with potatoes sautéed with garam masala, and turmeric', 8.99, 'Dinner', 'Yes', 'img/aloo_gobi.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Kofta', 'Gram flour balls fried with vegetables. Gram flour, veggies, rolled into balls with gram flour and fried in oil and then cooked with curry.', 7.99, 'Lunch', 'Yes', 'img/kofta.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Palek Paneer', 'Paneer cubes in spinach gravy', 9.99, 'Lunch', 'Yes', 'img/palek_paneer.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Vindaloo', 'Pork with goan red chili paste.', 10.50, 'Dinner', 'No', 'img/vindaloo.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Machher Jhol', 'Fish with curry and various spices', 10.99, 'Dinner', 'No', 'img/machher_jhol.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Tandoori Chicken', 'Chicken marinated in yogurt and spices overnight and roasted in a clay oven', 9.99, 'Dinner', 'No', 'img/tandoori_chicken.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Chicken Tikka Masala', 'Chicken cut up and stewed in a rich, spicy tomato-based sauce', 8.99, 'Dinner', 'No', 'img/chicken_tikka_masala.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Lamb Rogan Josh', 'Marinated lamb cooked with onions, peppers and spices', 10.99, 'Lunch', 'No', 'img/lamb_rogan_josh.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Chicken Jalfrezi', 'Chicken stir-fried with onions and peppers', 8.99, 'Lunch', 'No', 'img/chicken_jalfrezi.jpg');
insert into FOOD_ITEM (name, description, price, type, is_veg, image) values ('Chana Dal', 'Chick peas stewed in spices', 9.99, 'Lunch', 'Yes', 'img/chana_dal.jpg');

Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Aloo Gobi'),40201, 'Evening', sysdate, '09-DEC-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Aloo Gobi'),30201, 'Evening', sysdate, '09-DEC-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Kofta'),25301,'Morning', sysdate, '11-MAY-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Kofta'),10001, 'Morning', sysdate, '11-MAR-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Palek Paneer'),40201, 'Afternoon', sysdate, '09-NOV-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Vindaloo'),30201, 'Evening', sysdate, '01-OCT-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Palek Paneer'),25301,'Afternoon', sysdate, '09-NOV-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Vindaloo'),10001, 'Evening', sysdate, '01-OCT-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Machher Jhol'),40201, 'Evening', sysdate, '30-DEC-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Machher Jhol'),30201, 'Evening', sysdate, '30-DEC-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Machher Jhol'),25301,'Evening', sysdate, '30-DEC-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Machher Jhol'),10001, 'Evening', sysdate, '30-DEC-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Tandoori Chicken'),40201, 'Evening', sysdate, '30-SEP-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Tandoori Chicken'),30201, 'Evening', sysdate, '30-SEP-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Tandoori Chicken'),25301,'Evening', sysdate, '30-SEP-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Chicken Tikka Masala'),10001, 'Evening', sysdate, '10-JUN-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Lamb Rogan Josh'),40201, 'Afternoon', sysdate, '15-OCT-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Lamb Rogan Josh'),30201, 'Afternoon', sysdate, '15-OCT-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Chicken Jalfrezi'),25301,'Afternoon', sysdate, '30-AUG-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Chicken Jalfrezi'),10001, 'Afternoon', sysdate, '30-AUG-18');
Insert into Availability (FOOD_ITEM_id,zip_code, time, begin_date, end_date) values ((select FOOD_ITEM_id from FOOD_ITEM where name='Chana Dal'),10001, 'Afternoon', sysdate, '30-JUL-18');


INSERT into ORDERS (user_id,address_id,payment_type,order_date, price, delivery_date, delivery_time)values((Select user_id from online_user where First_name='Jane'),(Select Address_id from online_user where first_name='Jane'),'Card',sysdate, 20.00, last_day(sysdate), to_timestamp(last_day(sysdate)));
INSERT into ORDERS (user_id,address_id,payment_type,order_date, price, delivery_date, delivery_time)values((Select user_id from online_user where First_name='Dan'),(Select Address_id from online_user where first_name='Dan'),'Cash',sysdate, 10.00, last_day(sysdate), to_timestamp(last_day(sysdate)));
INSERT into ORDER_ITEMS (order_id, food_item_id, quantity)values((Select order_id from orders where price=20.00),(Select food_item_id from food_item where name='Chicken Jalfrezi'),1);
INSERT into ORDER_ITEMS (order_id, food_item_id, quantity)values((Select order_id from orders where price=10.00),(Select food_item_id from food_item where name='Tandoori Chicken'),2);
