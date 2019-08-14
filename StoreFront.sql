CREATE DATABASE storefront;


USE storefront;
CREATE TABLE user (
  
			
			UserId int NOT NULL AUTO_INCREMENT,
  
			
			Name varchar(255) NOT NULL,

			
			Email varchar(40) UNIQUE NOT NULL,
			Password varchar(20) NOT NULL,
  
			
			Phone VARCHAR(10) NOT NULL,
  
			
			UserType varchar(7) NOT NULL DEFAULT 'Shopper',
  
			
			PRIMARY KEY (UserId)

			
			);


CREATE TABLE shopper (
			
ShopperId int NOT NULL,

  
			PRIMARY KEY (ShopperId),
  
			FOREIGN KEY (ShopperId) REFERENCES user (userId)

			);




CREATE TABLE address(
			
AddressId int NOT NULL AUTO_INCREMENT,


  			
ShopperId int NOT NULL,
			HouseNo VARCHAR(255) NOT NULL,
			Area VARCHAR(255) NOT NULL,
			State VARCHAR(255) NOT NULL,
			ZipCode VARCHAR(6) NOT NULL,
			city VARCHAR(255) NOT NULL,
			KEY (AddressId),
			PRIMARY KEY (ShopperId,AddressId),
  
			FOREIGN KEY (ShopperId) REFERENCES shopper (ShopperId)

			);

CREATE TABLE admin (
  
			AdminId int NOT NULL,
  
			AdminKey VARCHAR(10) NOT NULL,
  
			PRIMARY KEY (AdminId),
  
			FOREIGN KEY (AdminId) REFERENCES user (UserId)
			
);



CREATE TABLE category (
  
			CategoryId int NOT NULL AUTO_INCREMENT,
  
			CategoryName varchar(50) NOT NULL,
			ParentCategoryId int NOT NULL DEFAULT 0,
  
			PRIMARY KEY (CategoryId)
			
);



CREATE TABLE product (
			ProductId int NOT NULL AUTO_INCREMENT,
  
			ProductName varchar(50) NOT NULL,

			Price double NOT NULL,
			Description varchar(1000) NOT NULL,  
			Stock int NOT NULL DEFAULT 0,
  
			PRIMARY KEY (Productid)

			);



CREATE TABLE images (
  
			ImageId int NOT NULL AUTO_INCREMENT,
  
			ProductId int,
			Url varchar(500) NOT NULL,
  
			PRIMARY KEY (Imageid),
  
			FOREIGN KEY (ProductId) REFERENCES product (ProductId)
			
);


CREATE TABLE categoryid (
  
			CategoryId int NOT NULL,
  
			ProductId int NOT NULL,
  
			PRIMARY KEY (CategoryId,ProductId),
  
			FOREIGN KEY (CategoryId) REFERENCES category (CategoryId)
			
);

CREATE TABLE Orders (

  
			OrderId int NOT NULL AUTO_INCREMENT,
  
			
			ShopperId int NOT NULL,

  
			AddressId int NOT NULL,

			OrderTotal double NOT NUll,
			OrderDate DATE NOT NULL,
			PRIMARY KEY (OrderId),

			FOREIGN KEY (ShopperId) REFERENCES shopper (ShopperId),

			FOREIGN KEY (AddressId) REFERENCES address(AddressId)
			);

CREATE TABLE orderedProducts(
			OrderId int NOT NULL,
			ProductId int NOT NULL,
			Quantity int NOT NULL DEFAULT 0,
			PRIMARY KEY (orderID,productId),
			FOREIGN KEY (orderId) REFERENCES orders (orderId),
			FOREIGN KEY (productId) REFERENCES product (productId)
			);

CREATE TABLE orderStatus (

  
			OrderId int NOT NULL,
 
			ProductId int NOT NULL,
 
			
			Status VARCHAR(20) CHECK(Status IN ('Shipped', 'Cancelled', 'Returned', 'Not Shipped')),
			ShippingDate DATE ,
  
			PRIMARY KEY (orderId,productId),

			FOREIGN KEY (orderId) REFERENCES orders (orderId),
			FOREIGN KEY (productId) REFERENCES orderedProducts (productId)
			);


