/**
  * Data Insertion in User Table
  */
INSERT INTO user (name,email,password,phone,type)

VALUES('Pankaj','pankaj@gmail.com','password',1111111111,'admin');


INSERT INTO user (name,email,password,phone)

VALUES('Shreyash','Shreyash@gmail.com','password',2222222222);


INSERT INTO user (name,email,password,phone)

VALUES('Manoj','Manoj@gmail.com','password',3333333333);


INSERT INTO user (name,email,password,phone)

VALUES('Pankaj','pankajkumar@gmail.com','password',4444444444);


INSERT INTO user (name,email,password,phone,type)

VALUES('Sabir','Sabir@gmail.com','password',5555555555,'admin');

/**
  * Data Insertion in Shopper Table
  */
INSERT INTO shopper (shopperId)

Select userId from user where type='shopper';

/**
  * Data Insertion in Address Table
  */
INSERT INTO address (addressId,shopperId,address)


VALUES(1,2,'First Add');



INSERT INTO address (addressId,shopperId,address)


VALUES(2,2,'Sec Add');



INSERT INTO address (addressId,shopperId,address)


VALUES(3,2,'Third Add');



INSERT INTO address (addressId,shopperId,address)


VALUES(4,3,'First Add');



INSERT INTO address (addressId,shopperId,address)


VALUES(5,4,'First Add');



INSERT INTO address (addressId,shopperId,address)


VALUES(6,4,'Sec Add');


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


VALUES('i5 Processor',15);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('i7 Processor',15);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Acer',16);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Acer',17);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Dell',16);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Dell',17);


INSERT INTO category (categoryName)


VALUES('Shoes');

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Puma',22);



INSERT INTO category (categoryName,parentcategoryId)


VALUES('Reebok',22);

INSERT INTO category (categoryName,parentcategoryId)


VALUES('Adidas',22);


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

INSERT INTO Orders (shopperId,shippingAddress)

VALUES(2,'First Add');


INSERT INTO Orders (shopperId,shippingAddress)

VALUES(2,'Third Add');


INSERT INTO Orders (shopperId,shippingAddress)

VALUES(3,'First Add');


INSERT INTO Orders (shopperId,shippingAddress)

VALUES(4,'Sec Add');


INSERT INTO Orders (shopperId,shippingAddress)

VALUES(4,'First Add');


INSERT INTO Orders (shopperId,shippingAddress)

VALUES(2,'Sec Add');