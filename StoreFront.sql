CREATE DATABASE storefront;


USE storefront;
CREATE TABLE user (
  
			
			userId int NOT NULL AUTO_INCREMENT,
  
			
			name varchar(255) NOT NULL,

			
			email varchar(40) UNIQUE NOT NULL,
			password varchar(20) NOT NULL,
  
			
			phone VARCHAR(10) NOT NULL,
  
			
			type varchar(7) NOT NULL DEFAULT 'shopper',
  
			
			PRIMARY KEY (userId)

			
			);


CREATE TABLE shopper (
			
shopperId int NOT NULL,

  
			PRIMARY KEY (shopperId),
  
			FOREIGN KEY (shopperId) REFERENCES user (userId)

			);




CREATE TABLE address(
			
addressId int NOT NULL AUTO_INCREMENT,


  			
shopperId int NOT NULL,
			address VARCHAR(255) NOT NULL,
			KEY (addressId),
			KEY (Address),
			PRIMARY KEY (shopperId,addressId),
  
			FOREIGN KEY (shopperId) REFERENCES shopper (shopperId)

			);

CREATE TABLE admin (
  
			adminId int NOT NULL,
  
			adminKey VARCHAR(10) NOT NULL,
  
			PRIMARY KEY (adminId),
  
			FOREIGN KEY (adminId) REFERENCES user (userId)
			
);



CREATE TABLE category (
  
			categoryId int NOT NULL AUTO_INCREMENT,
  
			categoryName varchar(50) NOT NULL,
			parentCategoryId int NOT NULL DEFAULT 0,
  
			PRIMARY KEY (categoryId)
			
);



CREATE TABLE product (
			productId int NOT NULL AUTO_INCREMENT,
  
			productName varchar(50) NOT NULL,

  			price double NOT NULL,
			description VARCHAR(1000) NOT NULL,	
			stock int NOT NULL DEFAULT 0,
  
			PRIMARY KEY (productId)

			);



CREATE TABLE images (
  
			imageId int NOT NULL AUTO_INCREMENT,
  
			productId int,

  			url VARCHAR(500) NOT NULL,
			PRIMARY KEY (imageId),
  
			FOREIGN KEY (productId) REFERENCES product (productId)
			
);


CREATE TABLE categoryid (
  
			categoryId int NOT NULL,
  
			productId int NOT NULL,
  
			PRIMARY KEY (categoryId,productId),
  
			FOREIGN KEY (categoryId) REFERENCES category (categoryId)
			
);

CREATE TABLE Orders (

  
			orderId int NOT NULL AUTO_INCREMENT,
  
			
			shopperId int NOT NULL,

  
			shippingAddress VARCHAR(255) NOT NULL,

			PRIMARY KEY (orderId),

			FOREIGN KEY (shopperId) REFERENCES shopper (ShopperId),


			FOREIGN KEY (shippingAddress) REFERENCES address (address)
			);

