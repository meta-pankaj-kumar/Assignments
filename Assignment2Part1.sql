/**
  * Data Insertion in User Table
  */
INSERT INTO user (Name,Email,Password,Phone,UserType)

VALUES('Pankaj','pankaj@gmail.com','password',1111111111,'admin');


INSERT INTO user (Name,Email,Password,Phone)

VALUES('Shreyash','Shreyash@gmail.com','password',2222222222);


INSERT INTO user (Name,Email,Password,Phone)

VALUES('Manoj','Manoj@gmail.com','password',3333333333);


INSERT INTO user (Name,Email,Password,Phone)

VALUES('Pankaj','pankajkumar@gmail.com','password',4444444444);


INSERT INTO user (Name,Email,Password,Phone,UserType)

VALUES('Sabir','Sabir@gmail.com','password',5555555555,'admin');

/**
  * Data Insertion in Shopper Table
  */
INSERT INTO shopper (shopperId)

Select userId from user where UserType='Shopper';

/**
  * Data Insertion in Address Table
  */
INSERT INTO address (addressId,shopperId,houseNo,area,state,zipCode,city)



VALUES(1,2,'house 1 of 2','Area of 2','State of 2','222222','City of 2');





INSERT INTO address (addressId,shopperId,houseNo,area,state,zipCode,city)



VALUES(2,2,'house 2 of 2','Area of 2','State of 2','222222','City of 2');





INSERT INTO address (addressId,shopperId,houseNo,area,state,zipCode,city)



VALUES(3,2,'house 3 of 2','Area of 2','State of 2','222222','City of 2');





INSERT INTO address (addressId,shopperId,houseNo,area,state,zipCode,city)



VALUES(4,3,'house 1 of 3','Area of 3','State of 3','333333','City of 3');





INSERT INTO address (addressId,shopperId,houseNo,area,state,zipCode,city)



VALUES(5,4,'house 1 of 4','Area of 4','State of 4','444444','City of 4');





INSERT INTO address (addressId,shopperId,houseNo,area,state,zipCode,city)



VALUES(6,4,'house 2 of 4','Area of 4','State of 4','444444','City of 4');



/**
  * Data Insertion in Admin Table
  */
INSERT INTO admin (adminId,adminKey)


VALUES(1,'pankaj');



INSERT INTO admin (adminId,adminKey)


VALUES(5,'sabir');

/**
  * Data Insertion in Category Table
  */
INSERT INTO category (categoryName)


VALUES('Electronics');



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Mobiles',1);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Android',2);



INSERT INTO category (categoryName,parentcategoryId)
VALUES('IOS',2);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Xiaomi',3);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Samsung',3);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Apple',4);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Laptops',1);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('i5 Processor',8);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('i7 Processor',8);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Acer',9);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Acer',10);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Dell',9);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Dell',10);


INSERT INTO category (categoryName)


VALUES('Shoes');

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Puma',15);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Reebok',15);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Adidas',15);


/**
  * Data Insertion in Product Table
  */

INSERT INTO product (productName,price,stock,description)

VALUES('Note 4',14999,15,'djhdfgjh');



INSERT INTO product (productName,price,stock,description)

VALUES('POCO F1',23999,10,'djhdfgjh');



INSERT INTO product (productName,price,stock,description)

VALUES('K2 pro',32999,8,'djhdfgjh');



INSERT INTO product (productName,price,stock,description)

VALUES('M20',13999,20,'djhdfgjh');



INSERT INTO product (productName,price,stock,description)

VALUES('Galaxy Edge',37999,15,'djhdfgjh');



INSERT INTO product (productName,price,stock,description)

VALUES('Note 4',14999,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('I Phone 5s',30000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('I Phone 7s',30000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('I Phone X',30000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('Acer Laptop i5',30000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('Acer Laptop i7',30000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('Acer Laptop i5 1',30000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)


VALUES('Acer Laptop i7 2',30000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Dell Laptop i5',30000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Dell Laptop i7',30000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Dell Laptop i7 2',30000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Dell Laptop i5 2',30000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Puma shoe 1',3000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Puma shoe 2',3000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)


VALUES('Puma shoe 3',3000,15,'djhdfgjh');


INSERT INTO product (productName,price,stock,description)



VALUES('Reebok shoe 1',3000,15,'djhdfgjh');




INSERT INTO product (productName,price,stock,description)



VALUES('Reebok shoe 2',3000,15,'djhdfgjh');




INSERT INTO product (productName,price,stock,description)



VALUES('Reebok shoe 3',3000,15,'djhdfgjh');

INSERT INTO product (productName,price,stock,description)



VALUES('Adidas shoe 1',3000,15,'djhdfgjh');




INSERT INTO product (productName,price,stock,description)



VALUES('Adidas shoe 2',3000,15,'djhdfgjh');




INSERT INTO product (productName,price,stock,description)



VALUES('Adidas shoe 3',3000,15,'djhdfgjh');

/**
  * Data Insertion in images Table
  */

INSERT INTO images (productId,url)


VALUES(1,'www.images.com/112314');


INSERT INTO images (productId,url)


VALUES(2,'www.images.com/112314');



INSERT INTO images (productId,url)


VALUES(2,'www.images.com/112314');



INSERT INTO images (productId,url)


VALUES(2,'www.images.com/112314');



INSERT INTO images (productId,url)


VALUES(2,'www.images.com/112314');


INSERT INTO images (productId,url)


VALUES(3,'www.images.com/112314');



INSERT INTO images (productId,url)


VALUES(3,'www.images.com/112314');



INSERT INTO images (productId,url)


VALUES(3,'www.images.com/112314');



INSERT INTO images (productId,url)


VALUES(3,'www.images.com/112314');


INSERT INTO images (productId,url)


VALUES(4,'www.images.com/112414');



INSERT INTO images (productId,url)


VALUES(4,'www.images.com/112414');



INSERT INTO images (productId,url)


VALUES(4,'www.images.com/112414');



INSERT INTO images (productId,url)


VALUES(4,'www.images.com/112414');


INSERT INTO images (productId,url)


VALUES(5,'www.images.com/112515');



INSERT INTO images (productId,url)


VALUES(5,'www.images.com/112515');



INSERT INTO images (productId,url)


VALUES(5,'www.images.com/112515');



INSERT INTO images (productId,url)


VALUES(5,'www.images.com/112515');


INSERT INTO images (productId,url)


VALUES(6,'www.images.com/112616');



INSERT INTO images (productId,url)


VALUES(6,'www.images.com/112616');



INSERT INTO images (productId,url)


VALUES(6,'www.images.com/112616');



INSERT INTO images (productId,url)


VALUES(6,'www.images.com/112616');


INSERT INTO images (productId,url)


VALUES(7,'www.images.com/112717');



INSERT INTO images (productId,url)


VALUES(7,'www.images.com/112717');



INSERT INTO images (productId,url)


VALUES(7,'www.images.com/112717');



INSERT INTO images (productId,url)


VALUES(7,'www.images.com/112717');


INSERT INTO images (productId,url)


VALUES(8,'www.images.com/112818');



INSERT INTO images (productId,url)


VALUES(8,'www.images.com/112818');



INSERT INTO images (productId,url)


VALUES(8,'www.images.com/112818');



INSERT INTO images (productId,url)


VALUES(8,'www.images.com/112818');


INSERT INTO images (productId,url)


VALUES(9,'www.images.com/112919');



INSERT INTO images (productId,url)


VALUES(9,'www.images.com/112919');



INSERT INTO images (productId,url)


VALUES(9,'www.images.com/112919');



INSERT INTO images (productId,url)


VALUES(9,'www.images.com/112919');


INSERT INTO images (productId,url)


VALUES(10,'www.images.com/11210110');



INSERT INTO images (productId,url)


VALUES(10,'www.images.com/11210110');



INSERT INTO images (productId,url)


VALUES(10,'www.images.com/11210110');



INSERT INTO images (productId,url)


VALUES(10,'www.images.com/11210110');


INSERT INTO images (productId,url)


VALUES(11,'www.images.com/11211111');



INSERT INTO images (productId,url)


VALUES(11,'www.images.com/11211111');



INSERT INTO images (productId,url)


VALUES(11,'www.images.com/11211111');



INSERT INTO images (productId,url)


VALUES(11,'www.images.com/11211111');


INSERT INTO images (productId,url)


VALUES(12,'www.images.com/12212121');



INSERT INTO images (productId,url)


VALUES(12,'www.images.com/12212121');



INSERT INTO images (productId,url)


VALUES(12,'www.images.com/12212121');



INSERT INTO images (productId,url)


VALUES(12,'www.images.com/12212121');


INSERT INTO images (productId,url)


VALUES(13,'www.images.com/13213131');



INSERT INTO images (productId,url)


VALUES(13,'www.images.com/13213131');



INSERT INTO images (productId,url)


VALUES(13,'www.images.com/13213131');



INSERT INTO images (productId,url)


VALUES(13,'www.images.com/13213131');

INSERT INTO images (productId,url)


VALUES(15,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(15,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(15,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(15,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(16,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(16,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(16,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(16,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(17,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(17,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(17,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(17,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(18,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(18,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(18,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(18,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(19,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(19,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(19,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(19,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(20,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(20,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(20,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(20,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(21,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(21,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(21,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(21,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(22,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(22,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(22,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(22,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(23,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(23,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(23,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(23,'www.images.com/14214141');




INSERT INTO images (productId,url)


VALUES(24,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(24,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(24,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(24,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(25,'www.images.com/14214141');


INSERT INTO images (productId,url)


VALUES(25,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(25,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(25,'www.images.com/14214141');

INSERT INTO images (productId,url)


VALUES(26,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(26,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(26,'www.images.com/14214141');



INSERT INTO images (productId,url)


VALUES(26,'www.images.com/14214141');

/**
  * Data Insertion in categoryId Table
  */

INSERT INTO categoryId (productId,categoryId)

VALUES(1,5);

INSERT INTO categoryId (productId,categoryId)

VALUES(1,6);



INSERT INTO categoryId (productId,categoryId)

VALUES(2,5);



INSERT INTO categoryId (productId,categoryId)

VALUES(3,5);



INSERT INTO categoryId (productId,categoryId)

VALUES(4,6);



INSERT INTO categoryId (productId,categoryId)

VALUES(5,6);



INSERT INTO categoryId (productId,categoryId)

VALUES(6,6);



INSERT INTO categoryId (productId,categoryId)

VALUES(7,7);



INSERT INTO categoryId (productId,categoryId)
VALUES(8,7);



INSERT INTO categoryId (productId,categoryId)

VALUES(9,7);



INSERT INTO categoryId (productId,categoryId)

VALUES(10,13);



INSERT INTO categoryId (productId,categoryId)

VALUES(12,13);

INSERT INTO categoryId (productId,categoryId)

VALUES(10,12);



INSERT INTO categoryId (productId,categoryId)

VALUES(12,12);



INSERT INTO categoryId (productId,categoryId)

VALUES(11,13);



INSERT INTO categoryId (productId,categoryId)

VALUES(13,13);



INSERT INTO categoryId (productId,categoryId)

VALUES(11,14);



INSERT INTO categoryId (productId,categoryId)

VALUES(13,14);



INSERT INTO categoryId (productId,categoryId)

VALUES(14,13);



INSERT INTO categoryId (productId,categoryId)

VALUES(17,13);



INSERT INTO categoryId (productId,categoryId)

VALUES(15,14);



INSERT INTO categoryId (productId,categoryId)

VALUES(16,14);



INSERT INTO categoryId (productId,categoryId)

VALUES(18,16);



INSERT INTO categoryId (productId,categoryId)

VALUES(19,16);



INSERT INTO categoryId (productId,categoryId)

VALUES(20,16);



INSERT INTO categoryId (productId,categoryId)

VALUES(21,17);



INSERT INTO categoryId (productId,categoryId)

VALUES(22,17);



INSERT INTO categoryId (productId,categoryId)

VALUES(23,17);



INSERT INTO categoryId (productId,categoryId)

VALUES(24,18);



INSERT INTO categoryId (productId,categoryId)

VALUES(25,18);



INSERT INTO categoryId (productId,categoryId)

VALUES(26,18);

/**
  * Data Insertion in Orders Table
  */

INSERT INTO orders (shopperId,addressId,orderDate,orderTotal)


VALUES(2,2,'2019-08-14',35999);



INSERT INTO orders (shopperId,addressId,orderDate,orderTotal)


VALUES(4,6,'2019-07-14',33000);



INSERT INTO orders (shopperId,addressId,orderDate,orderTotal)


VALUES(3,3,'2019-08-01',43999);



INSERT INTO orders (shopperId,addressId,orderDate,orderTotal)


VALUES(2,3,'2018-04-11',33000);



INSERT INTO orders (shopperId,addressId,orderDate,orderTotal)


VALUES(4,5,'2019-08-14',65999);



INSERT INTO orders (shopperId,addressId,orderDate,orderTotal)


VALUES(4,6,'2019-02-14',77999);






/**
  * Data Insertion in orderedProducts Table
  */



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(1,24,2);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(1,3,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(2,11,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(2,18,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(3,4,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(3,13,1);




INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(4,11,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(4,18,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(5,17,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(5,26,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(5,3,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(6,16,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(6,25,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(6,1,1);



INSERT INTO orderedProducts (orderId,productId,quantity)


VALUES(6,9,1);

/**
  * Data Insertion in orderStatus Table
  */



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(1,24,'Not Shipped','2019-08-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(1,3,'Not Shipped','2019-08-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(2,11,'Not Shipped','2019-07-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(2,18,'Returned','2019-07-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(3,4,'Shipped','2019-08-10');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(3,13,'Cancelled','2019-08-10');




INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(4,11,'Shipped','2018-04-21');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(4,18,'Returned','2018-04-21');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(5,17,'Not Shipped','2019-08-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(5,26,'Cancelled','2019-08-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(5,3,'Not Shipped','2019-08-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(6,16,'Shipped','2019-02-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(6,25,'Returned','2019-02-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(6,1,'Shipped','2019-02-24');



INSERT INTO orderStatus (orderId,productId,status,shippingDate)


VALUES(6,9,'Cancelled','2019-02-24');