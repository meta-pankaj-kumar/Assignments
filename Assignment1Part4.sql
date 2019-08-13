CREATE TABLE product (
			productId int NOT NULL AUTO_INCREMENT,
  
			productName varchar(50) NOT NULL,

  			price double NOT NULL,
			description VARCHAR(1000) NOT NULL,	
			stock int NOT NULL DEFAULT 0,
  
			PRIMARY KEY (productId)

			);

show tables;